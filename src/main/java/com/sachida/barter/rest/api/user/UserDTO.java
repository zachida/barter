package com.sachida.barter.rest.api.user;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private final String id;
    private final String name;
    private final String pass;
    private final String mail;
    private final Long dni;

    public UserDTO(String id, String name, String pass, String mail, Long dni) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.dni = dni;
    }

    public String getId() {
        return id;
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
