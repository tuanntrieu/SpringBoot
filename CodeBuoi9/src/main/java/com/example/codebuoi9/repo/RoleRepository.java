package com.example.codebuoi9.repo;

import com.example.codebuoi9.enums.EnumRole;
import com.example.codebuoi9.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findRoleByRoleName(EnumRole enumRole);
}
