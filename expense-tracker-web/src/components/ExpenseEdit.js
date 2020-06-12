import React from "react";
import { render } from "@testing-library/react";
import "../App.css";

class ExpenseEdit extends React.Component {

  constructor(props) {
    super(props)

    this.state = {
      name: '',
      amount: '',
      category: '',
      description: ''
    }
  }

  handleNameChange = e => {this.setState({ name: e.target.value })}

  handleAmountChange = e => {this.setState({ amount: e.target.value })}

  handleCategoryChange = e => {this.setState({ category: e.target.value })}

  handleDescriptionChange = e => {this.setState({ description: e.target.value })}

  
  handleCancelClick = e => {
    e.preventDefault();

    this.setState({
      name: '',
      amount: '',
      category: '',
      description: ''
    })

    this.props.toggleModal()
  }

  handleCreateClick = e => {
    e.preventDefault()

    if (this.state.name !== '' && this.state.amount !== '') {
      this.saveExpense()

      this.setState({
        name: '',
        amount: '',
        category: '',
        description: ''
      })
      this.props.toggleModal()
      // console.log(this.state.category)
    }
  }

  saveExpense() {
    // request options
    const options = {
      method: 'POST',
      body: JSON.stringify(this.state),
      headers: {
        'Content-Type': 'application/json'
      }
    }

    // send POST request
    fetch('http://localhost:8080/expense', options)
      .then(res => res.json())
      .then(res => this.props.add(res));
  }


  render() {
    return (
      <div className="edit">
        <form>
          <label className="name">Name</label>
          <input type="text" name="name" placeholder="Required" value={this.state.name} onChange={this.handleNameChange}></input>
          <br />
          <label>Amount $</label>
          <input type="text" name="amount" placeholder="Required" value={this.state.amount} onChange={this.handleAmountChange}></input>
          <br />
          <label className="category">Category</label>
          <select name="category" value={this.state.category} onChange={this.handleCategoryChange}>
            <option>Select one...</option>
            <option value="Dining">Dining</option>
            <option value="Travel">Travel</option>
            <option value="Grocery">Grocery</option>
            <option value="Shopping">Shopping</option>
            <option value="Education">Education</option>
            <option value="Entertainment">Entertainment</option>
            <option value="Other">Other</option>
          </select>
          <br />
          <label className="description">Description</label>
          <textarea className="descriptionBox" type="text" name="description" value={this.state.description} onChange={this.handleDescriptionChange}></textarea>
          <br />
          <button onClick={this.handleCreateClick}>Create</button>
          <button onClick={this.handleCancelClick}>Cancel</button>
          
        </form>
        {/* Edit Page */}
      </div>
    )
  }  
}

export default ExpenseEdit