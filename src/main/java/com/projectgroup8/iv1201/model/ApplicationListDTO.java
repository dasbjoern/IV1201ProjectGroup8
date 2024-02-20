package com.projectgroup8.iv1201.model;

public class ApplicationListDTO {
    private long applicationId;
    private long personId;
    private String status;
    private String name;
    private String surname;

    public ApplicationListDTO(Application app, Person person){
        this.applicationId = app.getApplicationId();
        this.personId = app.getPersonId();
        this.status = app.getStatus();
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
}
