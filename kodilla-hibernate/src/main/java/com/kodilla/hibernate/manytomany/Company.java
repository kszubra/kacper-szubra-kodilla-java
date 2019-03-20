package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.retrieveCompaniesStartingWith",
                query = "SELECT * FROM companies WHERE company_name LIKE CONCAT(:RENAME_ME,'%')"
        ),
        @NamedNativeQuery(
                name = "Company.retrieveCompaniesIncludingPhrase",
                query = "SELECT * FROM companies WHERE company_name LIKE CONCAT('$',:PHRASE,'%')"

        )

}

)

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    /***
     * argument mappedBy, który oznacza, że to mapowanie zostało już zdefiniowane przy właściwości companies encji Employee.
     * Gdybyśmy tego zapisu tutaj nie umieścili i ponownie wyspecyfikowali połączenie wraz z podaniem @JoiningTable - wówczas
     * wpisy w tabeli łączącej byłyby podwójne. Należy o tym zawsze pamiętać przy relacjach dwukierunkowyc
     */

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
