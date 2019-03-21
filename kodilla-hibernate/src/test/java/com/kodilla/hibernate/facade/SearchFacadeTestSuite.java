package com.kodilla.hibernate.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.SearchFacade;
import org.junit.Assert;
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
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    SearchFacade searchFacade;

    @Test
    public void testCompanySearch() {
        //Given
        Company testCompany1 = new Company("testIBM");
        Company testCompany2 = new Company("IBM Corp");
        Company testCompany3 = new Company("NewIBMCorp");

        companyDao.save(testCompany1);
        companyDao.save(testCompany2);
        companyDao.save(testCompany3);

        //When
        List<Company> companies = searchFacade.searchCompanyByPhrase("IBM");

        //Then
        Assert.assertTrue(companies.size() > 2);

        //Cleanup
        companyDao.delete(testCompany1);
        companyDao.delete(testCompany2);
        companyDao.delete(testCompany3);
    }

    @Test
    public void testEmployeeSearch() {
        //Given
        Employee testEmployee1 = new Employee("Jan", "Kowalski");
        Employee testEmployee2 = new Employee("Mariusz", "Kowalewski");
        Employee testEmployee3 = new Employee("Dariusz", "Zakowalski");

        employeeDao.save(testEmployee1);
        employeeDao.save(testEmployee2);
        employeeDao.save(testEmployee3);

        //When
        List<Employee> employees = searchFacade.searchEmployeeByPhrase("owal");

        //Then
        Assert.assertTrue(employees.size() > 2);

        //Cleanup
        employeeDao.delete(testEmployee1);
        employeeDao.delete(testEmployee2);
        employeeDao.delete(testEmployee3);


    }
}
