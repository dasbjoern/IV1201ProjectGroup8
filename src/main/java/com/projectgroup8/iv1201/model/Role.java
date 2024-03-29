package com.projectgroup8.iv1201.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * An entity for the role table in the database
 */
@Entity
@Table(name="role")
public class Role implements RoleDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private long roleId;
    
    @Column(name="name")
    private String name;
    
    public Role(){
        
    }
    public void setRoleId(long roleId){
        this.roleId = roleId;
    }
    public long getRoleId(){
        return this.roleId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
