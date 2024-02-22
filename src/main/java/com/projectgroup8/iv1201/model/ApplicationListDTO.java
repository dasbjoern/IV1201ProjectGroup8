package com.projectgroup8.iv1201.model;

/*
 * A DTO which does not represent a single object. It contains information from
 * both Application and Person
 */
public class ApplicationListDTO {
    private long applicationId;
    private long personId;
    private String status;
    private String name;
    private String surname;
    private long version;

    public ApplicationListDTO(Application app, Person person){
        this.applicationId = app.getApplicationId();
        this.personId = app.getPersonId();
        this.status = app.getStatus();
        this.version = app.getVersion();
        this.name = person.getName();
        this.surname = person.getSurname();
    }

    public long getApplicationId(){
        return this.applicationId;
    }

    public long getPersonId(){
        return this.personId;
    }

    public String getStatus(){
        return this.status;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public long getVersion(){
        return this.version;
    }
}
