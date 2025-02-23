package com.payroll.payrollapp.uc2;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create User (POST)
    @PostMapping("/add")
    public String addUser(@RequestParam String name) {
        int result = userRepository.addUser(new User(0, name));
        return result > 0 ? "User added successfully!" : "Failed to add user!";
    }

    // Get All Users (GET)
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    // Get User by ID (GET)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepository.getUserById(id);
    }

    // Update User (PUT)
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestParam String name) {
        int result = userRepository.updateUser(id, name);
        return result > 0 ? "User updated successfully!" : "Failed to update user!";
    }

    // Delete User (DELETE)
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        int result = userRepository.deleteUser(id);
        return result > 0 ? "User deleted successfully!" : "Failed to delete user!";
    }
}
