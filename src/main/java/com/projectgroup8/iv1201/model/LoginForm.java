package com.projectgroup8.iv1201.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginForm {
    
    @Size(min = 3, max = 30, message = "Username should be between 3 and 30 characters.")
    private String username;

    @Size(min = 3, max = 30, message = "Password should be between 3 and 30 characters.")
    private String password;

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
}
