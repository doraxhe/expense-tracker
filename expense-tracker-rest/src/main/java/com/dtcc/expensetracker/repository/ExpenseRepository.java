package com.dtcc.expensetracker.repository;

import com.dtcc.expensetracker.model.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    // what is Expense and Integer here??? Expense is the class we are using, Integer is the type of primary key
    List<Expense> findAll();
    Expense findById(int id);
//    List<Expenses> findByCategory(String category);
}