package com.projectgroup8.iv1201.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projectgroup8.iv1201.model.Application;

/**
 * A repository for the application table in the database
 */
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public List<Application> findAll();
}
