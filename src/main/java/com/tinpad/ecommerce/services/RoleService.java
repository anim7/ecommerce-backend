package com.tinpad.ecommerce.services;

import com.tinpad.ecommerce.dto.RoleDTO;
import com.tinpad.ecommerce.entities.Role;
import com.tinpad.ecommerce.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<RoleDTO> getRoleById(String id) {
        if(id != null) {
            Role role = roleRepository.findById(id).get();
            return List.of(new RoleDTO(role));
        }
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for(Role role : roles) {
            roleDTOs.add(new RoleDTO(role));
        }
        return roleDTOs;
    }

    public RoleDTO getRoleByName(String name) {
        return new RoleDTO(roleRepository.findByName(name));
    }

    public RoleDTO addRole(RoleDTO roleDTO) {
        Role role = new Role(roleDTO);
        roleRepository.save(role);
        roleDTO.setRoleId(role.getRoleId());
        return roleDTO;
    }

    public RoleDTO updateRole(RoleDTO roleDTO) {
        Role role = new Role(roleDTO);
        roleRepository.saveAndFlush(role);
        return roleDTO;
    }

    public List<RoleDTO> deleteRoleById(String id) {
        List<RoleDTO> roleDTOs = getRoleById(id);
        if(id != null) {
            roleRepository.deleteById(id);
        } else {
            roleRepository.deleteAll();
        }
        return roleDTOs;
    }

}
