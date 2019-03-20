package com.kodilla.hibernate.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.SearchFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    SearchFacade searchFacade;

    @Test
    public void testCompanySearch() {

        List<Company> companies = searchFacade.searchCompanyByPhrase("IBM");
    }

    @Test
    public void testEmployeeSearch() {

        List<Employee> employees = searchFacade.searchEmployeeByPhrase("kowal");

    }
}
