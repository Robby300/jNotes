package com.project.jNotes.repo;

import com.project.jNotes.domens.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
