import React, { Component } from 'react';

class ConsoleDropdown extends Component{
  constructor(props) {
    super(props);
    this.state = {
      consoles: [],
      pickedConsole: null,
    }
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/consoles').then(response => response.json())
    .then(data => this.setState({consoles: data})).catch(console.log("could not retrieve consoles"));
  }

  changeConsole(e) {
    this.setState({pickedConsole: e.target.value});
  }


  render() {

    const consoleMenu = this.state.consoles.map(c => {
      return(
        <div>
          <input type="radio" value={useId ? c.id : c.console} onChange={e=>this.changeConsole(e)} />
          {c.console}
        </div>
      );
    })

  }




}
