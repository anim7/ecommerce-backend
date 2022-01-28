package com.tinpad.ecommerce.repositories;

import com.tinpad.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> findByUserName(String username);
    @Query(value = "SELECT user_name FROM users WHERE user_name = :username", nativeQuery = true)
    public List<String> getUserNames(@Param("username") String username);
    @Query(value = "SELECT email FROM users WHERE email = :email", nativeQuery = true)
    public List<String> getEmails(@Param("email") String email);
}
