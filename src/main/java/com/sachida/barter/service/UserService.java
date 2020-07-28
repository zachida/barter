package com.sachida.barter.service;

import com.sachida.barter.datasource.model.User;
import com.sachida.barter.datasource.repository.UserRepository;
import com.sachida.barter.rest.api.exception.BarterAlreadyAUserException;
import com.sachida.barter.rest.api.exception.BarterException;
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
        if (!(createdUser(user))) {
            User userToSave = UserTranslator.translate(user);
            User saved = userRepository.save(userToSave);
            return UserTranslator.translate(saved);
        } else {
            throw new BarterAlreadyAUserException(String.format("User with mail %s or dni %s already exists.", user.getMail(), user.getDni()));
        }
    }



    public void deleteUser(String userId) {
        this.getRegisteredUser(userId);
        userRepository.deleteById(userId);
    }

    public UserDTO getUser(String userId) {
        return UserTranslator.translate(this.getRegisteredUser(userId));
    }

    public UserDTO modifyPass(String userId, NewPassRequestDTO dto) {
        User registeredUser = getRegisteredUser(userId);
        if (!registeredUser.getPass().equals(dto.getOldPass())) {
            throw new BarterException("La contraseña antigua no es la correcta");
        }
        if (!registeredUser.getPass().equals(dto.getNewPass())) {
            throw new BarterException("La contraseña actual debe ser diferente a la anterior");
        }

        registeredUser.setPass(dto.getNewPass());
        return UserTranslator.translate(userRepository.save(registeredUser));
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

    private boolean createdUser(UserRequestDTO user) {
        return userRepository.findByDniOrMail(user.getDni(), user.getMail()).isPresent();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
