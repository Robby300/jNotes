package com.project.jNotes.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserFormLogin {
    @NotEmpty
    @Length(max = 100)
    @Email
    private String email;

    @NotEmpty
    @Length(max = 255)
    private String password;

    @NotEmpty
    @Length(max = 255)
    private String passwordConfirmation;

}
