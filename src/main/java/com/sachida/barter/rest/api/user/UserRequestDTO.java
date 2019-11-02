package com.sachida.barter.rest.api.user;

import javax.validation.constraints.NotBlank;

public class UserRequestDTO {

    @NotBlank(message = "'name' is a required field.")
    private String name;
    @NotBlank(message = "'pass' is a required field.")
    private String pass;

    public UserRequestDTO(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
