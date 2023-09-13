package com.example.individual.controller;

import com.example.individual.model.Chat;
import com.example.individual.model.User;
import com.example.individual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    /**
     * Get all users.
     *
     * @return List of all users.
     */
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Get a user by their username.
     *
     * @param username The username of the user.
     * @return ResponseEntity containing the user if found, or a not-found response.
     */
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PatchMapping("/{username}")
    public ResponseEntity<User> patchUser(@PathVariable("username") String username, @RequestBody User updatedUser) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }


        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            user.setPassword(updatedUser.getPassword());
        }

        User updated = userRepository.save(user);
        return ResponseEntity.ok(updated);
    }

    /**
     * Create a new user.
     *
     * @param user The User object to be created.
     * @return ResponseEntity containing the created User object if successful, or a bad request response if the username already exists.
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Użytkownik o tej nazwie już istnieje."); // A bad request response with a message
        } else {


            User createdUser = userRepository.save(user);
            return ResponseEntity.ok(createdUser);
        }
    }



    /**
     * Update an existing user by username.
     *
     * @param username    The username of the user to be updated.
     * @param updatedUser The updated User object.
     * @return ResponseEntity containing the updated User object if found, or a not-found response.
     */
    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User updatedUser) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            // Aktualizuj pola użytkownika na podstawie wartości z updatedUser
            if (updatedUser.getEmail() != null) {
                user.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getPassword() != null) {
                user.setPassword(updatedUser.getPassword());
            }
            if (updatedUser.getName() != null) {
                user.setName(updatedUser.getName());
            }
            if (updatedUser.getSurname() != null) {
                user.setSurname(updatedUser.getSurname());
            }
            if (updatedUser.getYearOfBirth() != null) {
                user.setYearOfBirth(updatedUser.getYearOfBirth());
            }
            if (updatedUser.getGender() != null) {
                user.setGender(updatedUser.getGender());
            }
            if (updatedUser.getAvatarIndex() != 0) {
                user.setAvatarIndex(updatedUser.getAvatarIndex());
            }
            if (updatedUser.getRating() != 0.0) {
                user.setRating(updatedUser.getRating());
            }


            User updated = userRepository.save(user);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    /**
     * Delete a user by username.
     *
     * @param username The username of the user to be deleted.
     * @return ResponseEntity containing a success message if the user is deleted, or a not-found response.
     */
    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
            return ResponseEntity.ok("Deleted."); // A success message
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

