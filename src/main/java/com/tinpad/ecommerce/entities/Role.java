package com.tinpad.ecommerce.entities;

import com.tinpad.ecommerce.dto.RoleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@NoArgsConstructor
public class Role {

    @Id
    @GenericGenerator(name = "role_id", strategy = "com.tinpad.ecommerce.generator.RoleIdGenerator")
    @GeneratedValue(generator = "role_id")
    @Column(nullable = false, length = 9)
    private String roleId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    public Role(String roleId, String name, String description) {
        setRoleId(roleId);
        setName(name);
        setDescription(description);
    }

    public Role(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public Role(@NotNull RoleDTO roleDTO) {
        setRoleId(roleDTO.getRoleId());
        setName(roleDTO.getName());
        setDescription(roleDTO.getDescription());
    }

    public void setRoleId(String roleId) {
        if(roleId != null && roleId.length() == 9) {
            this.roleId = roleId;
        }
    }

    public void setName(@NotNull String name) {
        this.name = name.toUpperCase();
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
