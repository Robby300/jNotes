package com.project.jNotes.repo;

import com.project.jNotes.domens.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
