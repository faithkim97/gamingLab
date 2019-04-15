import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';
import GenreDropdown from './GenreDropdown';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import {Form, Table} from 'react-bootstrap';

function createGenreList(masterGames) {
  const genreMaps = [];
  masterGames.map(mg => {
    if (mg.genreMap != null) {
      genreMaps.push(mg.genreMap);
    }
  });
  return genreMaps;
}

function createGenreTable(genreTable) {
  return(
    <table>
      <tbody>
        <tr>
          <th>Map ID</th>
          <th>Current Genre</th>
          <th>Edit Genre To:</th>
          <th></th>
        </tr>
        {genreTable}
      </tbody>
    </table>
  );
}


class EditGenreTable extends Component {

    constructor(props) {
      super(props);
    }

    deleteGenreMapping(e, mapId){
      fetch('http://localhost:8080/admin/deleteGenreMap?mapId='+mapId);
      window.location.reload();
    }

    handleAddGenre(e) {
      console.log(e);
      fetch('http://localhost:8080/admin/mapGenreByGameGenreIds?gameId='+this.props.value[0].game.id+"&genreIds="+e);

    }

    render() {
      const masterGames = this.props.value;
      const genres = createGenreList(masterGames);
      const seen = new Set();
      const genreEntries = masterGames.map(mg => {
        if (mg.genreMap != null && !seen.has(mg.genreMap.id)) {
          seen.add(mg.genreMap.id);
          return(
            <GameFieldEntry id={mg.genreMap.id} field = {mg.genreMap != null ? mg.genreMap.genre.genre : null} onClick={e =>this.deleteGenreMapping(e, mg.genreMap.id)}/>
          );
        }
      });

      return(
        <div style={{backgroundColor: "#00ffbf", width:"50%", padding: "2%"}}>
      <Table striped bordered hover variant="dark" size="sm">
        <thead>
          <tr>
            <th>Map Id</th>
            <th>Genre</th>
            <th></th>
          </tr>
          {genreEntries}
        </thead>
      </Table>
        <GenreDropdown value = {masterGames[0].game} onAdd={e => this.handleAddGenre(e)} useId={true} editMode={true}/>
      </div>

      );
    }


}

export default EditGenreTable;
