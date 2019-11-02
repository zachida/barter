package com.sachida.barter.rest.api.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewPassRequestDTO {

    @NotBlank(message = "'old_pass' is a required field.")
    @Size(min = 8, max = 100, message = "Wrong 'old_pass' length.")
    private String oldPass;
    @NotBlank(message = "'new_pass' is a required field.")
    @Size(min = 8, max = 100, message = "Wrong 'new_pass' length.")
    private String newPass;

    public NewPassRequestDTO(String oldPass, String newPass) {
        this.oldPass = oldPass;
        this.newPass = newPass;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
