package com.sachida.barter.service;

import com.sachida.barter.datasource.model.User;
import com.sachida.barter.datasource.repository.UserRepository;
import com.sachida.barter.rest.api.exception.BarterAlreadyAUserException;
import com.sachida.barter.rest.api.user.NewPassRequestDTO;
import com.sachida.barter.rest.api.user.UserRequestDTO;
import com.sachida.barter.rest.api.exception.BarterNotFoundException;
import com.sachida.barter.rest.api.user.UserDTO;
import com.sachida.barter.rest.controller.translator.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserDTO createUser(UserRequestDTO user) {
        if (!(userRepository.findByDni(user.getDni().toString()).isPresent() ||
                userRepository.findByMail(user.getMail()).isPresent())) {
            User userToSave = UserTranslator.translate(user);
            User saved = userRepository.save(userToSave);
            return UserTranslator.translate(saved);
        } else {
            throw new BarterAlreadyAUserException("User already exists.");
        }
    }

    public void deleteUser(String userId) {
        this.getRegisteredUser(userId);
        userRepository.deleteById(userId);
    }

    public UserDTO getUser(String userId) {
        return UserTranslator.translate(this.getRegisteredUser(userId));
    }

    //TODO esto se puede hacer de otra menera si tener que rellenar de nuevo todos los campos
    public UserDTO modifyPass(String userId, NewPassRequestDTO dto) {
        User registeredUser = getRegisteredUser(userId);
        //Validar si coincide la old pass
        User userToModify = new User();
        userToModify.setId(registeredUser.getId());
        userToModify.setPass(dto.getNewPass());
        userToModify.setName(registeredUser.getName());
        userToModify.setMail(registeredUser.getMail());
        userToModify.setDni(registeredUser.getDni());
        return UserTranslator.translate(userRepository.save(userToModify));
    }

    private User getRegisteredUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BarterNotFoundException(String.format("%s is not a user id", userId)));
    }

    public void checkIfExistUserId(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new BarterNotFoundException(String.format("%s is not a user id", userId));
        }
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
