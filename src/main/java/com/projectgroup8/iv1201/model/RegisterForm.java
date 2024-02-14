package com.projectgroup8.iv1201.model;


import jakarta.validation.constraints.NotBlank;

/**
 * A form for when a new person is registered
 * Inspired by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/presentation/acct/CreateAcctForm.java
 */
public class RegisterForm {
    @NotBlank(message = "Name must be specified")
    private String name;
    @NotBlank(message = "Surname must be specified")
    private String surname;
    @NotBlank(message = "Person number must be specified")
    private String pnr;
    @NotBlank(message = "E-mail must be specified")
    private String email;
    @NotBlank(message = "Password must be specified")
    private String password;
    @NotBlank(message = "Username must be specified")
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
