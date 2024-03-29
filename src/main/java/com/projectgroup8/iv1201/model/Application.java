package com.projectgroup8.iv1201.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * An entity for an application table in the database
 */

@Entity
@Table(name="application")
public class Application implements ApplicationDTO {

    public Application(){

    }

    public Application(long appId, long personId, String status){
        this.applicationId = appId;
        // this.personId = personId;
        this.status = status;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_id")
    private long applicationId;

    @Column(name="person_id")
    private long personId;

    @Column(name="status")
    private String status;

    @Column(name="version")
    private long version;

    public long getApplicationId(){
        return this.applicationId;
    }

    public long getPersonId(){
        return this.personId;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String newStatus) throws RecruitmentException{
        if(!(newStatus.equals("ACCEPTED") || newStatus.equals("REJECTED") || newStatus.equals("UNHANDLED"))){
           throw new RecruitmentException("Invalid application status");
        }
        this.status = newStatus;
    }

    public long getVersion(){
        return this.version;
    }

    public void incrementVersion(){
        this.version++;
    }



}
