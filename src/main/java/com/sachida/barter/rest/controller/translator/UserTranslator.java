package com.sachida.barter.rest.controller.translator;

import com.sachida.barter.datasource.model.User;
import com.sachida.barter.rest.api.user.UserDTO;
import com.sachida.barter.rest.api.user.UserRequestDTO;

public class UserTranslator {

    public static User translate(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPass(dto.getPass());
        user.setMail(dto.getMail());
        user.setDni(dto.getDni());
        return user;
    }

    public static UserDTO translate(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getPass(),
                user.getMail(),
                user.getDni()
        );
    }
}
