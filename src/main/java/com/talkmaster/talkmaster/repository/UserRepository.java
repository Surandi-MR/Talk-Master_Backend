package com.talkmaster.talkmaster.repository;

import com.talkmaster.talkmaster.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    // Fetch users by name
    List<User> findByFirstName(String firstName);

    // Fetch users by role
    List<User> findByRole(String role);

    // Fetch users by both name and role
    List<User> findByFirstNameAndRole(String firstName, String role);

    // Fetch a user by email
    Optional<User> findByEmail(String email);
}
