import React from "react";
import "../App.css";

function ExpenseComponent(props) { 

  if (props.expense.category !== '' && props.expense.description !== '') {
    return (
      <div className={props.className}>
        <p style={{ float: "left", paddingLeft: "5px" }}> {props.expense.name} ({props.expense.category}: {props.expense.description})</p>
        <p style={{ float: "right", paddingRight: "5px" }}> ${props.expense.amount}</p>        
        <div style={{ clear: "both" }} />
      </div>
    )
  }

  else if (props.expense.category !== '') {
    return (
      <div className={props.className}>
        <p style={{ float: "left", paddingLeft: "5px" }}> {props.expense.name} ({props.expense.category})</p>
        <p style={{ float: "right", paddingRight: "5px" }}> ${props.expense.amount}</p>        
        <div style={{ clear: "both" }} />
      </div>
    )
  }

  else if (props.expense.description !== '') {
    return (
      <div className={props.className}>
        <p style={{ float: "left", paddingLeft: "5px" }}> {props.expense.name} ({props.expense.description})</p>
        <p style={{ float: "right", paddingRight: "5px" }}> ${props.expense.amount}</p>        
        <div style={{ clear: "both" }} />
      </div>
    )
  }

  else return (
    <div className={props.className}>
      <p style={{ float: "left", paddingLeft: "5px" }}> {props.expense.name} </p>
      <p style={{ float: "right", paddingRight: "5px" }}> ${props.expense.amount} </p>      
      <div style={{ clear: "both" }} />
    </div>
  )
}

export default ExpenseComponent
