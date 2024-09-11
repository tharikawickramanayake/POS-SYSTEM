package io.java.springbootstarter.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.springbootstarter.Model.User;
import io.java.springbootstarter.Repository.UserRepository;

@Service
public class UserService {

	    @Autowired
	    private UserRepository userRepository;

	    // Get all users
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    // Get a user by ID
	    public Optional<User> getUserById(Long id) {
	        return userRepository.findById(id);
	    }


	    // Create a new user
	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    // Update an existing user
	    public Optional<User> updateUser(Long id, User updatedUser) {
	        return userRepository.findById(id).map(user -> {
	            user.setUsername(updatedUser.getUsername());
	            user.setPasswordHash(updatedUser.getPasswordHash());
	            user.setRole(updatedUser.getRole());
	            return userRepository.save(user);
	        });
	    }

	    // Delete a user by ID
	    public boolean deleteUser(Long id) {
	        if (userRepository.existsById(id)) {
	            userRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	
}
