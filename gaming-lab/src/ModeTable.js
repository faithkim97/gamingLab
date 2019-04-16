import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';
import {Table} from 'react-bootstrap';

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
    fetch('http://localhost:8080/admin/deleteMode?modeId='+modeId).then(() => {window.location.reload()});

  }

  render() {
    const modes = this.state.modes;
    const modeMap = modes.map(m => {
      return(
        <GameFieldEntry id={m.id} field={m.mode} onClick={e =>this.deleteMode(e, m.id)} />
      );
    });

    return(
      <div style={{width:"50%", margin:"0 auto"}}>
        <Table striped bordered hover variant="dark">
          <thead>
            <tr>
              <th>Playable Mode ID</th>
              <th>Genre</th>
              <th></th>
            </tr>
          </thead>
          {modeMap}
        </Table>
      </div>
    );


  }


}

export default ModeTable;
