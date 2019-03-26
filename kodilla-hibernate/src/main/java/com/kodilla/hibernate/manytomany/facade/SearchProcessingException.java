package com.kodilla.hibernate.manytomany.facade;

public class SearchProcessingException extends Exception {
    public static final String COMPANY_NOT_FOUND = "Company was not found";
    public static final String EMPLOYEE_NOT_FOUND = "Employee was not found";

    public SearchProcessingException(String message) {
        super(message);
    }
}
