package com.project.jNotes.service;

import com.project.jNotes.domens.Role;
import com.project.jNotes.domens.User;
import com.project.jNotes.repo.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    public User returnUser = User.builder()
            .username("Oleg")
            .id(99L).roles(Collections.singleton(Role.USER))
            .password("123").build();

    @Test
    void returnedUserByIdIsCorrect() {
        when(userService.findByUsername("Oleg")).thenReturn(returnUser);

        User user = userService.findByUsername("Oleg");
        assertFalse(user == null);

        assertTrue(user.getRoles().contains(Role.USER));
        assertEquals(user.getUsername(), "Oleg");
        assertEquals(user.getId(), 99L);
        assertEquals(user.getPassword(), "123");
    }
}