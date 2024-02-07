package com.projectgroup8.iv1201.model;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * An entity for the availability table in the database
 */
@Entity
@Table(name="availability")
public class Availability implements AvailabilityDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="availability_id")
    private long availabilityId; 
    
    @Column(name="person_id")
    private long personId;

    @Column(name="from_date")
    private Date fromDate;

    @Column(name="to_date")
    private Date toDate;

    public void setAvailabilityId(long availabilityId){
        this.availabilityId = availabilityId;
    }
    public long getAvailabilityId(){
        return this.availabilityId;
    }
    
    public void setPersonId(long personId){
        this.personId = personId;
    }
    public long getPersonId(){
        return this.personId;
    }

    public void setFromDate(Date fromDate){
        this.fromDate = fromDate;
    }
    public Date getFromDate(){
        return this.fromDate;
    }
    public void setToDate(Date toDate){
        this.toDate = toDate;
    }
    public Date getToDate(){
        return this.toDate;
    }

    public Availability(){

    }
    public Availability(long availabilityId, long personId, Date fromDate, Date toDate){
        this.availabilityId = availabilityId;
        this.personId = personId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
