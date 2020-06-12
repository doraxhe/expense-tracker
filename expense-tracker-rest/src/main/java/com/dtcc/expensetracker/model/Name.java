package com.dtcc.expensetracker.model;

import javax.persistence.*;

@Entity
@Table(name = "name")
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleInitial;

    @Column(name = "lastName")
    private String lastName;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleInitial;
    }

    public void setMiddleName(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
