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
public class CompetenceProfile{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="competence_profile_id")
    private long competenceProfileId;
    
    @Column(name="person_id")
    private long personId;
    
    @Column(name="competence_id")
    private long competenceId;

    //numeric(4,2)

    @Column(name="years_of_experience")
    private BigDecimal yearsOfExperience;
    
    public CompetenceProfile(){
        
    }
    public void setCompetenceProfileId(long competenceProfileId){
        this.competenceProfileId = competenceProfileId;
    }
    public long getCompetenceProfileId(){
        return this.competenceProfileId;
    }
    public void setPersonId(long personId){
        this.personId = personId;
    }
    public long getPersonId(){
        return this.personId;
    }
    public void setCompetenceId(long competenceId){
        this.competenceId = competenceId;
    }
    public long getCompetenceId(){
        return this.competenceId;
    }
    public void setYearsOfExperience(BigDecimal yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }
    public BigDecimal getYearsOfExperience(){
        return this.yearsOfExperience;
    }
}
