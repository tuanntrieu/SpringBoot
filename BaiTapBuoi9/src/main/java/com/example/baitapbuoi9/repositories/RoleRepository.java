package com.example.baitapbuoi9.repositories;

import com.example.baitapbuoi9.enums.EnumRole;
import com.example.baitapbuoi9.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Enumeration;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findRoleByRoleName(EnumRole roleName);
}
