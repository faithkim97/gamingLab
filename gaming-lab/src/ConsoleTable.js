import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';

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
    // window.location.reload();
  }

  render() {
    const consoles = this.state.consoles;
    const consoleMap = consoles.map(c => {
      return(
        <GameFieldEntry id={c.id} field={c.console} onClick={e => this.deleteConsole(e, c.id)} />
      );
    });

    return(
      <div>
        <table>
          <tr>
            <th>Console ID</th>
            <th>Console</th>
            <th></th>
          </tr>
          {consoleMap}
        </table>
      </div>
    );

  }

}

export default ConsoleTable;
