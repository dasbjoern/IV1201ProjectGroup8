package com.projectgroup8.iv1201.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="application")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_id")
    private long applicationId;

    @Column(name="person_id")
    private long personId;

    @Column(name="status")
    private String status;
}
