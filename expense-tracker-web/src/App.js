import React from "react";
import "./App.css";
import ExpenseListView from "./components/ExpenseListView";
import ExpenseEdit from "./components/ExpenseEdit";
// import { Modal } from 'reactstrap';
import Modal from 'react-modal';


class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      expenses: [],
      mode: "VIEW",
      isModalOpen: false
    }
  }

  // toggleMode() {
  //   this.setState({ 
  //     mode: this.state.mode === "VIEW" ? "EDIT" : "VIEW" });
  // }

  addExpense = expense => {
    // let newList = [...this.state.expenses]
    this.setState({
      expense: [].concat(this.state.expenses, expense),
      expenses: [...this.state.expenses, expense]
    })
  }

  componentDidMount() {
    fetch("http://localhost:8080/expenses")
      .then((response) => response.json())
      .then(data => this.setState({expenses: data}));
  }

  toggleModal = () => {
    this.setState({ isModalOpen: !this.state.isModalOpen })
  }


  render() {
    return (
      <div className="App">
        <h1>Expense Tracker</h1>
        <button onClick={this.toggleModal}>New</button>

        <Modal isOpen={this.state.isModalOpen}>
          <ExpenseEdit 
            add={this.addExpense}
            toggleModal={this.toggleModal}
            // delete={this.deleteExpense}
          />
        </Modal>

        <ExpenseListView
          expenses={this.state.expenses}
        />
      </div>
    );
  }
}

export default App;
