package edu.fiu.gt.profilemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful controller for the User entity. Handles Get, Post, and Put requests.
 *
 * @author Alvaro
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = service.getAllUsers();
        if(userList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = service.getUserById(id);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = service.getUserByUsername(username);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        User user = service.createUser(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User newUser) {
        if(newUser.getEmail() != null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        User updatedUser = service.updateUser(username, newUser);
        if(updatedUser == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
