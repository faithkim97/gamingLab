import React, { Component } from 'react';
import ConsoleTable from './ConsoleTable';
import {Form, Button} from 'react-bootstrap';

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
    fetch('http://localhost:8080/admin/addConsole?console='+this.state.newConsole).then(() => {window.location.reload()});
  }

  render() {
    return(
      <div style={{backgroundColor: "white", width:"80%", margin:"0 auto"}}>
        <h1 style={{textAlign:"center"}}>Edit Consoles</h1>
        <ConsoleTable />
        <div style={{width:"30%", margin:"0 auto"}}>
          <Form.Group >
            <Form.Control value={this.state.newConsole} onChange={e=>this.handleChange(e)} />
          {/*<input type = "text" value={this.state.newConsole} onChange={e=>this.handleChange(e)} />*/}
          <Button onClick={e=>this.handleClick(e)}>Add New Console</Button>
          </Form.Group>
        </div>
      </div>
    );
  }


}

export default EditConsolePage;
