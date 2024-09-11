package io.java.springbootstarter.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.java.springbootstarter.Model.User;
import io.java.springbootstarter.Service.UserService;

@RestController
public class UserController {

	    @Autowired
	    private UserService userService;

	    // Get all users
	    @GetMapping("/user")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

	    // Get user by ID
	    @GetMapping("user/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        Optional<User> user = userService.getUserById(id);
	        return user.map(ResponseEntity::ok)
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }


	    // Create a new user
	    @PostMapping("/user")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User createdUser = userService.createUser(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }

	    // Update a user
	    @PutMapping("user/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
	        Optional<User> updatedUser = userService.updateUser(id, user);
	        return updatedUser.map(ResponseEntity::ok)
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    // Delete a user
	    @DeleteMapping("user/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        if (userService.deleteUser(id)) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
}
