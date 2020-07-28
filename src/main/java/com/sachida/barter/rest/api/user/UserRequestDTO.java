package com.sachida.barter.rest.api.user;

import javax.validation.constraints.NotBlank;

public class UserRequestDTO {

    @NotBlank(message = "'name' is a required field.")
    private final String name;
    //TODO aca debe venir plana? o se debe encriptar en el front?
    @NotBlank(message = "'pass' is a required field.")
    private final String pass;
    @NotBlank(message = "'mail' is a required field.")
    private final String mail;
    @NotBlank(message = "'dni' is a required field.")
    private final Long dni;
    //TODO ubicacion

    public UserRequestDTO(String name, String pass, String mail, Long dni) {
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getMail() {
        return mail;
    }

    public Long getDni() {
        return dni;
    }

}
