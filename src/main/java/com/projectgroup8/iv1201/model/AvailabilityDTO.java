package com.projectgroup8.iv1201.model;

import java.sql.Date;

/**
 * A DTO interface for the availability table in the database
 */
public interface AvailabilityDTO {

    public long getAvailabilityId();
    

    public long getPersonId();

   
    public Date getFromDate();

    public Date getToDate();
    
}
