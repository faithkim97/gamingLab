import React, { Component } from 'react';
import ConsoleTable from './ConsoleTable';

class EditConsolePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newConsole: '',
    };
  }

  handleChange(e) {
    this.setState({newConsole: e.target.value});
  }

  handleClick(e) {
    fetch('http://localhost:8080/admin/addConsole?console='+this.state.newConsole);
    window.location.reload();
  }

  render() {
    return(
      <div>
        <h1>Edit Consoles</h1>
        <ConsoleTable />
        <input type = "text" value={this.state.newConsole} onChange={e=>this.handleChange(e)} />
        <button onClick={e=>this.handleClick(e)}>Add New Console</button>
      </div>
    );
  }


}

export default EditConsolePage;
