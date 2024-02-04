package com.projectgroup8.iv1201.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projectgroup8.iv1201.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRoleId(Long roleId);
    Role findByName(String name);
}
