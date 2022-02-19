package com.project.jNotes.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserFormLogin {
    @NotEmpty
    @Length(max = 100)
    @Email
    private String username;

    @NotEmpty
    @Length(max = 255)
    private String password;
}
