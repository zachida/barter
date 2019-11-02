package com.sachida.barter.rest.controller.translator;

import com.sachida.barter.datasource.model.User;
import com.sachida.barter.rest.api.user.UserDTO;
import com.sachida.barter.rest.api.user.UserRequestDTO;

public class UserTranslator {

    public static User translate(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPass(dto.getPass());
        return user;
    }

    public static UserDTO translate(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setPass(user.getPass());
        dto.setId(user.getId());
        return dto;
    }
}
