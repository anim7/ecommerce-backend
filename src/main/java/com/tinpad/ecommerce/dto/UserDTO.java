package com.tinpad.ecommerce.dto;

import com.tinpad.ecommerce.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Getter
@NoArgsConstructor
public class UserDTO implements UserDetails {

    private String userId;

    private String userName;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String password;

    private String email;

    private RoleDTO role;

    private Boolean active;

    public UserDTO(String userId, String userName, String firstName, String lastName, Date dateOfBirth, String password, String email, RoleDTO role, Boolean active) {
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

    public UserDTO(String userName, String firstName, String lastName, Date dateOfBirth, String password, String email, RoleDTO role, Boolean active) {
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setPassword(password);
        setEmail(email);
        setRole(role);
        setActive(active);
    }

    public UserDTO(@NotNull User user) {
        setUserId(user.getUserId());
        setUserName(user.getUserName());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setDateOfBirth(user.getDateOfBirth());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setRole(new RoleDTO(user.getRole()));
        setActive(user.getActive());
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

    public void setEmail(@NotNull String email) {
        if(email.contains("@") && email.contains(".") && !email.contains(" ")) {
            this.email = email;
        }
    }

    public void setRole(@NotNull RoleDTO role) {
        this.role = role;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
