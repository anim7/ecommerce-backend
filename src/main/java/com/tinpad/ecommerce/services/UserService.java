package com.tinpad.ecommerce.services;

import com.tinpad.ecommerce.dto.UserDTO;
import com.tinpad.ecommerce.entities.User;
import com.tinpad.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUserById(String id) {
        if(id != null) {
            User user = userRepository.findById(id).get();
            return List.of(new UserDTO(user));
        }
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user : users) {
            userDTOs.add(new UserDTO(user));
        }
        return userDTOs;
    }

    public List<String> getUserNames(String username) {
        return userRepository.getUserNames(username);
    }

    public List<String> getEmails(String email) {
        return userRepository.getEmails(email);
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        userDTO.setUserId(user.getUserId());
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.saveAndFlush(user);
        return userDTO;
    }

    public List<UserDTO> deleteUserById(String id) {
        List<UserDTO> userDTOs = getUserById(id);
        if(id != null) {
            userRepository.deleteById(id);
        } else {
            userRepository.deleteAll();
        }
        return userDTOs;
    }

}
