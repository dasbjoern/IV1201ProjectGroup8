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


public interface PersonDTO{   
   
    public long getPersonId();
    
    public String getName();

    public String getSurname();

  
    public String getPnr();

  
    public String getEmail();
    
    public long getRoleId();

    public String getUsername();
    
    // public boolean login(String password);
}
