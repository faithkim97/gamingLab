import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';

class ModeTable extends Component {

  constructor(props) {
    super(props);
    this.state = {
      modes: [],
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/modes').then(response => response.json())
    .then(data => this.setState({modes: data}));
  }

  deleteMode(e, modeId) {
    fetch('http://localhost:8080/admin/deleteMode?modeId='+modeId);
    window.location.reload();
  }

  render() {
    const modes = this.state.modes;
    const modeMap = modes.map(m => {
      return(
        <GameFieldEntry id={m.id} field={m.mode} onClick={e =>this.deleteMode(e, m.id)} />
      );
    });

    return(
      <div>
        <table>
          <tbody>
            <tr>
              <th>Playable Mode ID</th>
              <th>Genre</th>
              <th></th>
            </tr>
            {modeMap}
          </tbody>
        </table>
      </div>
    );


  }


}

export default ModeTable;
