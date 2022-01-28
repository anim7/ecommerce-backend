package com.tinpad.ecommerce.controllers;

import com.tinpad.ecommerce.dto.RoleDTO;
import com.tinpad.ecommerce.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<RoleDTO> getRoleById(@RequestParam(required = false, name = "id") String id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    public RoleDTO addRole(@RequestBody RoleDTO roleDTO) {
        return roleService.addRole(roleDTO);
    }

    @PutMapping
    public RoleDTO updateRole(@RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(roleDTO);
    }

    @DeleteMapping
    public List<RoleDTO> deleteRoleById(@RequestParam(required = false, name = "id") String id) {
        return roleService.deleteRoleById(id);
    }

}
