package com.projectgroup8.iv1201.model;
import java.math.BigDecimal;

public class CompetenceInfoDTO {
    private long competenceId;
    private long competenceProfileId;
    private long personId;
    private String competenceName;
    private BigDecimal yearsOfExperience;

    public CompetenceInfoDTO(CompetenceProfile profile, String competenceName){
        this.competenceId = profile.getCompetenceId();
        this.competenceProfileId = profile.getCompetenceProfileId();
        this.personId = profile.getPersonId();
        this.competenceName = competenceName;
        this.yearsOfExperience = profile.getYearsOfExperience();
    }

    public long getCompetenceId(){
        return competenceId;
    }

    public long getCompetenceProfileId(){
        return competenceProfileId;
    }

    public long getPersonId(){
        return personId;
    }

    public String getCompetenceName(){
        return competenceName;
    }

    public BigDecimal getYearsOfExperience(){
        return yearsOfExperience;
    }

    public String getYearsOfExperienceString(){
        return yearsOfExperience.toString();
    }

}
