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
    
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;
    
    @Column(name="person_id")
    private long person_id;

    @Column(name="from_date")
    private Date from_date;

    @Column(name="to_date")
    private Date to_date;

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
    
   
    public void setPerson_id(long person_id){
        this.person_id = person_id;
    }
    public long getPerson_id(){
        return this.person_id;
    }

    public void setFrom_date(Date from_date){
        this.from_date = from_date;
    }
    public Date getFrom_date(){
        return this.from_date;
    }
    public void setTo_date(Date to_date){
        this.to_date = to_date;
    }
    public Date getTo_date(){
        return this.to_date;
    }

    public Availability(){

    }
    public Availability(long id, Date from_date, Date to_date){
        
    }
}
