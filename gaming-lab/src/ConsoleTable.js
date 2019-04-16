import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';
import {Table} from 'react-bootstrap';

class ConsoleTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      consoles: [],
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/consoles').then(response => response.json())
    .then(data => this.setState({consoles: data}));
  }

  deleteConsole(e, consoleId) {
    console.log(consoleId);
    fetch('http://localhost:8080/admin/deleteConsole?consoleId='+consoleId);
    window.location.reload();
  }

  render() {
    const consoles = this.state.consoles;
    const consoleMap = consoles.map(c => {
      return(
        <GameFieldEntry id={c.id} field={c.console} onClick={e => this.deleteConsole(e, c.id)} />
      );
    });

    return(
      <div style={{width:"50%", margin:"0 auto"}}>
        <Table striped bordered hover variant="dark">
          <thead>
            <tr>
              <th>Console ID</th>
              <th>Console</th>
              <th></th>
            </tr>
          </thead>
          {consoleMap}
        </Table>
      </div>
    );

  }

}

export default ConsoleTable;
