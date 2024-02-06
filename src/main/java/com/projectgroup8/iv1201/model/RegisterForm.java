package com.projectgroup8.iv1201.model;

/**
 * A form for when a new person is registered
 */
public class RegisterForm {
    
    private String name;
    private String surname;
    private String pnr;
    private String email;
    private String password;
    private String username;

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

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
}
