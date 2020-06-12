package com.dtcc.expensetracker.controller;

import com.dtcc.expensetracker.model.Expense;
import com.dtcc.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController // The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web.
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    //    Request: GET /ping
//    Response: "Up"
    @GetMapping("/ping") // The @GetMapping(“/ping”) tells Spring to use our ping() method to answer requests that get sent
    public String ping(){
        return "Up";
    }

    //    Request: GET /expenses
//    Response: Expense[]
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    //    Request: GET /expense/{id}
//    Response: Expense
    @GetMapping("/expense/{id}")
    public Expense getExpenseById(@PathVariable int id){
        return expenseRepository.findById(id);
    }

    //    Request: POST /expense Expense
//    Response: Expense
    @PostMapping("/expense")
    public Expense saveExpense(@RequestBody Expense expense){
        return expenseRepository.save(expense);
    }

    //    Request: DELETE /expense/{id}
//    Response: void
    @DeleteMapping("/expense/{id}")
    public void deleteExpenseById(@PathVariable Long id){
        expenseRepository.deleteById(id);
    }

    //    Request: DELETE /expense Expense
//    Response: void
    @DeleteMapping("/expense")
    public void deleteExpense(@RequestBody Expense expense){
        expenseRepository.delete(expense);
    }

}

// @GetMapping("/hello")
//public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//return String.format("Hello %s!", name);
//}
// the @RequestParam is telling Spring to expect a name value in the request, but if it’s not there, it will use the word “World” by default.