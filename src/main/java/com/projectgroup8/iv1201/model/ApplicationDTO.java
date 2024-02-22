package com.projectgroup8.iv1201.model;

/*
 * A DTO interface for an application table in the database
 */
public interface ApplicationDTO {
    public long getApplicationId();
    public long getPersonId();
    public String getStatus();
}
