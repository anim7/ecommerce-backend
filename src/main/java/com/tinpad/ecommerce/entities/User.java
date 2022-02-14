package com.tinpad.ecommerce.entities;

import com.tinpad.ecommerce.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {


    @Id
    @GenericGenerator(name = "user_id", strategy = "com.tinpad.ecommerce.generator.UserIdGenerator")
    @GeneratedValue(generator = "user_id")
    @Column(length = 9, nullable = false)
    private String userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Boolean active;

    public User(String userId, String userName, String firstName, String lastName, Date dateOfBirth, String password, String email, Role role, Boolean active) {
        setUserId(userId);
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setPassword(password);
        setEmail(email);
        setRole(role);
        setActive(active);
    }

    public User(String userName, String firstName, String lastName, Date dateOfBirth, String password, String email, Role role) {
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setPassword(password);
        setEmail(email);
        setRole(role);
        setActive(active);
    }

    public User(@NotNull UserDTO userDTO) {
        setUserId(userDTO.getUserId());
        setUserName(userDTO.getUsername());
        setFirstName(userDTO.getFirstName());
        setLastName(userDTO.getLastName());
        setDateOfBirth(userDTO.getDateOfBirth());
        setPassword(userDTO.getPassword());
        setEmail(userDTO.getEmail());
        setRole(new Role(userDTO.getRole()));
        setActive(userDTO.getActive());
    }

    public void setUserId(String userId) {
        if(userId != null && userId.length() == 9) {
            this.userId = userId;
        }
    }

    public void setUserName(@NotNull String userName) {
        if(userName.length() >= 2 && userName.length() <= 20 && !userName.contains(" ")) {
            this.userName = userName;
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassword(@NotNull String password) {
        if(password.length() >= 8) {
            this.password = password;
        }
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public void setEmail(@NotNull String email) {
        if(email.contains("@") && email.contains(".") && !email.contains(" ")) {
            this.email = email;
        }
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
