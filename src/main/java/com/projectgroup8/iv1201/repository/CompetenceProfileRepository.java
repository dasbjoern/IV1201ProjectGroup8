package com.projectgroup8.iv1201.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.CompetenceProfile;

@Repository
public interface CompetenceProfileRepository extends JpaRepository<CompetenceProfile, Long>{
    public CompetenceProfile findByCompetenceId(long competenceId);
    public List<CompetenceProfile> findAllByPersonId(long personId);
}
