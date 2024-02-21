package com.projectgroup8.iv1201.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * A form for when a new person is registered
 * Inspired by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/presentation/acct/CreateAcctForm.java
 */
public class RegisterForm {
    @NotBlank(message = "Name must be specified")
    @Size(message = "The name must be between 2 and 30 characters long", min = 2, max = 30)
    private String name;
    @NotBlank(message = "Surname must be specified")
    @Size(message = "The surname must be between 2 and 30 characters long", min = 2, max = 30)
    private String surname;
    @NotBlank(message = "Person number must be specified")
    @Size(message = "The person number must be between 10 and 13 characters long", min = 10, max = 13)
    private String pnr;
    @NotBlank(message = "E-mail must be specified")
    @Size(message = "The email must be between 5 and 50 characters long", min = 5, max = 50)
    private String email;
    @NotBlank(message = "Password must be specified")
    @Size(message = "The password must be between 3 and 30 characters long", min = 3, max = 30)
    private String password;
    @NotBlank(message = "Username must be specified")
    @Size(message = "The username must be between 3 and 30 characters long", min = 3, max = 30)
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
