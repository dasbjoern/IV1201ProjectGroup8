package com.projectgroup8.iv1201.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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

    public long getApplicationId(){
        return this.applicationId;
    }

    public long getPersonId(){
        return this.personId;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String newStatus){
        if(!newStatus.equals("ACCEPTED") || !newStatus.equals("REJECTED") || !newStatus.equals("UNHANDLED")){
            // Error handling here
            return;
        }
        this.status = newStatus;
    }



}
