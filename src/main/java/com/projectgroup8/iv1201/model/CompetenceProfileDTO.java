package com.projectgroup8.iv1201.model;
import java.math.BigDecimal;

/**
 * A DTO interface for the competence profile table in the database
 */
public interface CompetenceProfileDTO {
    public long getCompetenceProfileId();
    public long getPersonId();
    public long getCompetenceId();
    public BigDecimal getYearsOfExperience();

}
