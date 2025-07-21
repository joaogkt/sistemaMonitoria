package org.monitoria.sistemamonitoria.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.monitoria.sistemamonitoria.DTO.UserDTO;
import org.monitoria.sistemamonitoria.Models.User;
import org.monitoria.sistemamonitoria.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "User management APIs")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    };
    @Operation(summary = "Get user by id", description = "Returns the user with the id")
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

}
