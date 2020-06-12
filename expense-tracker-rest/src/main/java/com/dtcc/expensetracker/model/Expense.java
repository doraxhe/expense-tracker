package com.dtcc.expensetracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // using TABLE enables queries in create.sql to be used in MySQL db
    // automatically generate and keep track of IDs by using a table "hibernate_sequences", the query of creating this table is in create.sql file
    private Long id;

    @Column(name="name") // change to whatever column name that's actually in your db
    // if java class property name is equal to db column name, no need to add this annotation.
    private String name;

    @Column(name="amount")
    private double amount;

    @Column(name="category")
    private String category;

    @Column(name="description")
    private String description;

//    @ManyToOne
//    @JoinColumn(name="user_id") // in expense table, user_id is foreign key
//    private User user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

}