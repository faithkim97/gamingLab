import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';
import ModeDropdown from './ModeDropdown';
import {Table} from 'react-bootstrap';
import {adminFetch} from "./Admin";

function createModeList(masterGames) {
  const modeMaps = [];
  masterGames.map(mg => {
    if (mg.genreMap != null) {
      modeMaps.push(mg.genreMap);
    }
  });
  return modeMaps;
}

class EditModeTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      modes:[],
    }
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/modes').then(response => response.json())
    .then(data => this.setState({modes: data})).catch(console.log("could not retrieve modes"));
  }

  deleteModeMapping(e, mapId) {
    let url = 'http://localhost:8080/admin/deleteModeMap?mapId='+mapId;
    adminFetch(url).then(() => {window.location.reload();});
  }
  handleAddMode(e) {
    let url = 'http://localhost:8080/admin/mapModeByModeGameIds?gameId='+this.props.value[0].game.id+"&modeIds="+e;
    adminFetch(url).then(() => {window.location.reload();});
  }

  render() {
    const masterGames = this.props.value;
    const modes = createModeList(masterGames);
    const seen = new Set();
    const modeEntries = masterGames.map(mg => {
      if (mg.modeMap != null && !seen.has(mg.modeMap.id)){
        seen.add(mg.modeMap.id);
        return (
          <GameFieldEntry id={mg.modeMap != null ? mg.modeMap.id : null} field = {mg.modeMap != null ? mg.modeMap.playableMode.mode : null}
           onClick = {e=> this.deleteModeMapping(e, mg.modeMap.id)}/>
        );
      }
    });

    return(
      <div style={{backgroundColor: "#00ffbf", width: "50%", padding:"2%"}}>
        <Table striped bordered hover variant="dark" size="sm">
          <tbody>
            <tr>
              <th>Map Id</th>
              <th>Playable Mode</th>
              <th></th>
            </tr>
            {modeEntries}
          </tbody>
        </Table>
        <ModeDropdown value = {masterGames[0].game} onAdd={e=>this.handleAddMode(e)} useId={true} editMode={true}/>
      </div>
    );

  }


}

export default EditModeTable;
