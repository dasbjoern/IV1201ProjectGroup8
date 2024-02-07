package com.projectgroup8.iv1201.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projectgroup8.iv1201.model.Application;

/**
 * A repository for the application table in the database
 * Inspired by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/repository/AccountRepository.java
 */
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public List<Application> findAll();
}
