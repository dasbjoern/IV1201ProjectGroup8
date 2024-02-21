package com.projectgroup8.iv1201.model;

public class RecruitmentException extends Exception { 
    
    /**
     * Generic exception for buisness logic
     * @param errorMessage
     */
    public RecruitmentException(String errorMessage) {
        super(errorMessage);
    }
}