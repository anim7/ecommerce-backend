package com.tinpad.ecommerce.dto;

import com.tinpad.ecommerce.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
public class RoleDTO {

    private String roleId;

    private String name;

    private String description;

    public RoleDTO(String roleId, String name, String description) {
        setRoleId(roleId);
        setName(name);
        setDescription(description);
    }

    public RoleDTO(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public RoleDTO(@NotNull Role role) {
        setRoleId(role.getRoleId());
        setName(role.getName());
        setDescription(role.getDescription());
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
