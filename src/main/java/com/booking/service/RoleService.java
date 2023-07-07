package com.booking.service;

import com.booking.payload.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO createRole(RoleDTO roleDTO);

    void deleteRole(Long id);

    RoleDTO updateRole(Long id, RoleDTO roleDTO);

    List<RoleDTO> getAllRoles();

    RoleDTO getRoleById(Long id);
}
