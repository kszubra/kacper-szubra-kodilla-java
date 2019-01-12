package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //cleanup

        try{
            companyDao.delete(softwareMachine);
        } catch (Exception e) {
            //move on
        }
        try{
            companyDao.delete(dataMaesters);
        } catch (Exception e) {
            //move on
        }
        try{
            companyDao.delete(greyMatter);
        } catch (Exception e) {
            //move on
        }


    }

    @Test
    public void testGettingEmployeesByLastName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieSmith = new Employee("Stephanie", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.saveAll(Arrays.asList(johnSmith, stephanieSmith, lindaKovalsky));
        //When
        List<Employee> smithList = employeeDao.retrieveEmployeeByLastName("Smith");
        int expectedSmithNumber =2;

        //Then
        Assert.assertEquals(expectedSmithNumber, smithList.size());


        //cleanup
        try{
            employeeDao.deleteAll();
        } catch (Exception e) {
            //move on
        }

    }

    @Test
    public void testGettingCompanyByFirstCharacters() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        companyDao.saveAll(Arrays.asList(softwareMachine, dataMaesters, greyMatter));

        //When
        List<Company> companyList = companyDao.retrieveCompaniesStartingWith("So");

        //Then
        Assert.assertEquals(1, companyList.size());
    }
}
