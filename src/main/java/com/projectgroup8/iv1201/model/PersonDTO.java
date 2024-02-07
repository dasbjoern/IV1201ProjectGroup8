package com.projectgroup8.iv1201.model;

/**
 * A DTO interface for the person table in the database
 */
public interface PersonDTO{   
   
    public long getPersonId();
    
    public String getName();

    public String getSurname();

  
    public String getPnr();

  
    public String getEmail();
    
    public long getRoleId();

    public String getUsername();

}
