package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    public Role findByRoleId(long roleId);
    public Role findByName(String name);
}
