package com.project.jNotes.controllers;

import com.project.jNotes.domens.Role;
import com.project.jNotes.domens.User;
import com.project.jNotes.forms.UserFormRegistration;
import com.project.jNotes.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserFormRegistration userFormRegistration, Map<String, Object> model) {
        User userFromDb = userService.findByUsername(userFormRegistration.getUsername());
        if (userFromDb != null) {
            model.put("message", "Пользователь уже создан!");
            return "registration";
        }
        if (userFormRegistration.getPassword().equals(userFormRegistration.getPasswordConfirmation())) {
            User user = User.builder()
                    .username(userFormRegistration.getUsername())
                    .password(passwordEncoder.encode(userFormRegistration.getPassword()))
                    .roles(Collections.singleton(Role.USER))
                    .build();
            userService.save(user);
            return "redirect:/login";
        } else {
            model.put("message", "Пароли не совпадают");
        }
        return "registration";
    }

    @GetMapping("/login-failure")
    public String signInFailure(ModelMap modelMap) {
        modelMap.put("message", "Неправильный логин или пароль.");
        return "login";
    }
}
