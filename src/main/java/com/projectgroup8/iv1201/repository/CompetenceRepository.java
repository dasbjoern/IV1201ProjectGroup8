package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectgroup8.iv1201.model.Competence;

/**
 * A repository for hte competence table in the database
 * Inspired by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/repository/AccountRepository.java
 */
@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    public Competence findById(long id);
    public Competence findByName(String name);
}
