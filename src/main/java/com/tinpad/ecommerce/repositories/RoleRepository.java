package com.tinpad.ecommerce.repositories;

import com.tinpad.ecommerce.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    @Query(value = "SELECT * FROM roles WHERE name = :name", nativeQuery = true)
    public Role findByName(@Param("name") String name);
}
