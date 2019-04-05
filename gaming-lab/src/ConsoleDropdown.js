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
    console.log(e.target.value);
    this.setState({pickedConsole: e.target.value}, () => {
      if(!this.props.editMode) {
        const onAdd = this.props.onAdd;
        onAdd(this.state.pickedConsole);
      }
    });
  }


  render() {
    const useId = this.props.useId;
    const consoleMenu = this.state.consoles.map(c => {
      return(
        <div>
          <input type="radio" value={useId ? c.id : c.console} onChange={e=>this.changeConsole(e)} />
          {c.console}
        </div>
      );
    })

    return(
      <div>
        {consoleMenu}
      </div>
    );

  }




}

export default ConsoleDropdown;
