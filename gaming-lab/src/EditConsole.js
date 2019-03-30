import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';

class EditConsole extends Component {
  constructor(props) {
    super(props);
    this.state = {
      consoles: [],
      pickedConsole: -1,
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/consoles').then(response => response.json())
    .then(data => this.setState({consoles: data})).catch(console.log("could not retrieve consoles"));
  }

  handleInputChange(id) {
    //delayed reaciton, pickedConsole doesn't get changed right away
    this.setState({pickedConsole: id});
  }

  changeConsole(e, mapId, gameId) {
    fetch('http://localhost:8080/admin/replaceConsoleMap?mapId='+mapId+"&consoleId="+this.state.pickedConsole
  +"&gameId="+gameId);
  window.location.reload();
  

  }

  handleDeleteConsole(e, mapId) {
    fetch("http://localhost:8080/admin/deleteConsoleMap?mapId="+mapId)
  }


  render() {
    const consoles = this.state.consoles;
    const masterGames = this.props.value;
    let consoleMap = null;

    for (let i = 0; i < masterGames.length; i++) {
      if (masterGames[i].consoleMap != null) {
        consoleMap = masterGames[i].consoleMap;
        break;
      }
    }


    //TODO can i make this the same as search engine so that it' not repetitive coding
    const consoleMenu = consoles.map(c => {
      return(
        <div>
          <input type="radio" name ="consoles" value={c.id} onChange={e => this.handleInputChange(c.id)} />{c.console}
        </div>
      );
    });



    const consoleEntry = consoleMap != null ? <GameFieldEntry id={consoleMap.id} field={consoleMap.console.console}
    onClick={e => this.handleDeleteConsole(e, consoleMap.id)}/> : null;


    return(
      <div>
        <table>
          <tbody>
            <tr>
              <th>Map Id</th>
              <th>Console</th>
              <th></th>
            </tr>
            {consoleEntry}
          </tbody>
        </table>
        {consoleMenu}
        <button onClick={e => this.changeConsole(e, consoleMap != null ? consoleMap.id : -1
          , masterGames[0].game.id)}>Change Console</button>
      </div>

    );


  }


}

export default EditConsole;
