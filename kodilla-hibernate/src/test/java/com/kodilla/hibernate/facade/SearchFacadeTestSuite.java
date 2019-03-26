package com.kodilla.hibernate.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.SearchFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
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

    @Before
    public void clearDatabaseBeforeTest() {
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @Test
    public void testCompanySearch() {
        //Given
        Company testCompany1 = new Company("testIBM");
        Company testCompany2 = new Company("IBM Corp");
        Company testCompany3 = new Company("NewIBMCorp");
        Company testCompany4 = new Company("Not to include");

        companyDao.saveAll(Arrays.asList(testCompany1, testCompany2, testCompany3, testCompany4));

        //When
        List<Company> companies = searchFacade.searchCompanyByPhrase("IBM");

        //Then
        Assert.assertEquals(3, companies.size() );
        Assert.assertTrue(companies.contains(testCompany1));
        Assert.assertTrue(companies.contains(testCompany2));
        Assert.assertTrue(companies.contains(testCompany3));

    }

    @Test
    public void retrieveEmployeeIncludingPhrase() {
        //Given
        Employee employee1 = new Employee("abc","zxc");
        Employee employee2 = new Employee("ghj", "iop");
        employeeDao.saveAll(Arrays.asList(employee1, employee2));

        //When
        List<Employee> result = searchFacade.searchEmployeeByPhrase("x");

        //Then
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), employee1);
    }


}
