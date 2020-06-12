package com.dtcc.expensetracker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    // TABLE means all ids are stored in the table
    private Long id;

    @JoinColumn(name = "name_id") // the foreign key that links the user table and name table is "name_id"
    @OneToOne(cascade = CascadeType.ALL)
    // @Column(name = "name") name table is a table not a column
    private Name name;

    @JoinColumn(name = "user_id") // give a foreign key column of "user_id" in expenses table
    @OneToMany(cascade = CascadeType.ALL)
    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // a property cannot have "mappedBy" and @JoinColumn at the same time
    // mappedBy refers to the One side of the relationship
    // CascadeType.ALL: if the user is changed, all his expense info in the table is changed
    // @Column(name = "expense") expense table is a table not a column
    private List<Expense> expenses;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

}
