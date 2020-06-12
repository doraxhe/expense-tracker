import React from "react";
import ExpenseComponent from "./ExpenseComponent";
// import axios from 'axios'

function ExpenseListView(props) {
  let body = [];

  props.expenses.forEach((expense) => {
    body.push(<ExpenseComponent expense={expense} className={expense.category}/>);
  });

  return (
    <div>
      {body}
    </div>
  );
}

export default ExpenseListView
