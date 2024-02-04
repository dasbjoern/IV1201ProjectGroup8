package com.projectgroup8.iv1201.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import java.math.BigDecimal;
import jakarta.persistence.Table;

@Entity
@Table(name="competence_profile")
public class Competence_profile{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="competence_profile_id")
    private long id;
    
    @Column(name="person_id")
    private long person_id;

    @Column(name="competence_id")
    private long competence_id;

    //numeric(4,2)

    @Column(name="years_of_experience")
    private BigDecimal years_of_experience;
    
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
    public void setCompetence_id(long competence_id){
        this.competence_id = competence_id;
    }
    public long getCompetence_id(){
        return this.competence_id;
    }
    public void setYears_of_experience(BigDecimal years_of_experience){
        this.years_of_experience = years_of_experience;
    }
    public BigDecimal setYears_of_experience(){
        return this.years_of_experience;
    }
}
