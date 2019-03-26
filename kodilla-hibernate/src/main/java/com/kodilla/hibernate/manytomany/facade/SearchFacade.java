package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class SearchFacade {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    public List<Company> searchCompanyByPhrase(String phrase) {
        LOGGER.info("Searching for the company including phrase: {}", phrase);

        List<Company> searchResult = companyDao.retrieveCompaniesIncludingPhrase(phrase);
        LOGGER.info("Result size is: " + searchResult.size());

        if (searchResult.isEmpty()) {
            LOGGER.error("Error: " + SearchProcessingException.COMPANY_NOT_FOUND);
            LOGGER.info("An error interrupted process, returning empty list");
            return searchResult;
        }

        LOGGER.info("Returning non-empty list");
        return searchResult;
    }

    public List<Employee> searchEmployeeByPhrase(String phrase) {
        LOGGER.info("Searching for the employee with surname including phrase: {}", phrase);

        List<Employee> searchResult = employeeDao.retrieveEmployeeIncludingPhrase(phrase);
        LOGGER.info("Result size is: " + searchResult.size());

        if (searchResult.isEmpty()) {
            LOGGER.error("Error: " + SearchProcessingException.EMPLOYEE_NOT_FOUND);
            LOGGER.info("An error interrupted process, returning empty list");
            return searchResult;
        }

        LOGGER.info("Returning non-empty list");
        return searchResult;
    }
}
