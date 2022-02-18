package com.project.jNotes.service;

import com.project.jNotes.repo.NoteRepository;
import com.project.jNotes.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public UserServiceImpl(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByUserEmail(email);
    }
}
