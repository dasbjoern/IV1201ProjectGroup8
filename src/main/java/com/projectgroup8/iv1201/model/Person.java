package com.projectgroup8.iv1201.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="surname")
    private String surname;

    @Column(name="pnr")
    private String pnr;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role_id")
    private long role_id;

    @Column(name="username")
    private String username;

    @OneToMany(mappedBy = "person")
    private List<Availability> availability;

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return this.surname;
    }

    public void setPnr(String pnr){
        this.pnr = pnr;
    }
    public String getPnr(){
        return this.pnr;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setRole_id(long role_id){
        this.role_id = role_id;
    }
    public long getRole_id(){
        return this.role_id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
}
