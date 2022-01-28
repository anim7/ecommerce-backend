package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.UserDTO;
import com.tinpad.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsersById(@RequestParam(required = false, name = "id") String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{username}")
    public List<String> getUserNames(@PathVariable String username) {
        return userService.getUserNames(username);
    }

    @GetMapping("/email/{email}")
    public List<String> getEmails(@PathVariable String email) {
        return userService.getEmails(email);
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping
    public List<UserDTO> deleteUserById(@RequestParam(required = false, name = "id") String id) {
        return userService.deleteUserById(id);
    }

}
