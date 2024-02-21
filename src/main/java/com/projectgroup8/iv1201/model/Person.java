package com.projectgroup8.iv1201.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 * An entity for the person table in the database
 */
@Entity
@Table(name="person")
public class Person implements PersonDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private long personId;
    
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
    private long roleId;

    @Size(min = 5, max = 255)
    @Column(name="username")
    private String username;
    
    @Column(name="salt")
    private String salt;

    // @OneToMany(mappedBy = "person")
    // private List<Availability> availability;
    public Person(){
        
    }
    public Person(PersonDTO personDTO){
        this.personId = personDTO.getPersonId();
        this.name = personDTO.getName();
        this.surname = personDTO.getSurname();
        this.pnr = personDTO.getPnr();
        this.email = personDTO.getEmail();
        this.roleId = personDTO.getRoleId();
        this.username = personDTO.getUsername();
    }
    public void setPersonId(long personId){
        this.personId = personId;
    }
    public long getPersonId(){
        return this.personId;
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
    public void setSalt(String salt){
        this.salt = salt;
    }
    public String getSalt(){
        return this.salt;
    }
    public void setRoleId(long roleId){
        this.roleId = roleId;
    }
    public long getRoleId(){
        return this.roleId;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public long login(String password){
        if(this.password.equals(password)){
            return this.personId;
        }
        else
           return (long)-1;
    }
}
