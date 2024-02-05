package com.projectgroup8.iv1201.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="competence")
@NamedQuery(name = "Competence.findname", query = "SELECT name FROM Competence")
public class Competence implements CompetenceDTO{

    public Competence(){
    }
    public Competence(long competenceId, String name){
        this.competenceId = competenceId;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="competence_id")
    private long competenceId;
    
    @Column(name="name")
    private String name;
    
    public void setCompetenceId(long competenceId){
        this.competenceId = competenceId;
    }
    public long getCompetenceId(){
        return this.competenceId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
