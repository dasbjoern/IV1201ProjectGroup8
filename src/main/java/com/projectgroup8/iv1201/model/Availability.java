package com.projectgroup8.iv1201.model;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="availability")
public class Availability{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="availability_id")
    private long id; 
    
    // @ManyToOne
    // @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    // private Person person;
    
    @Column(name="person_id")
    private long personId;

    @Column(name="from_date")
    private Date fromDate;

    @Column(name="to_date")
    private Date toDate;

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
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
    public Availability(long id, long personId, Date fromDate, Date toDate){
        
    }
}
