import React, { Component } from 'react';
import EditGenreEntry from './EditGenreEntry';
import GenreDropdown from './GenreDropdown';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";


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
      this.state = {
        genres: [],
      };
    }

    componentDidMount() {
      fetch('http://localhost:8080/game/genres').then(response => response.json())
      .then(data => this.setState({genres: data})).catch(console.log("could not retrieve genres"));

    }

    deleteGenreMapping(e, mapId){
      fetch('http://localhost:8080/admin//deleteGenreMap?mapId='+mapId);
      console.log("deleting genre map: "+ mapId);
    }

    render() {
      const masterGames = this.props.value;
      const genres = createGenreList(masterGames);
      const genreEntries = masterGames.map(mg => {
        if (mg.genreMap != null) {
          return(
            <EditGenreEntry value={mg} onClick={e =>this.deleteGenreMapping(e, mg.genreMap.id)}/>
          );
        }
      });

      return(
        <div>
      <table>
        <tbody>
          <tr>
            <th>Map Id</th>
            <th>Genre</th>
            <th></th>
          </tr>
          {genreEntries}
          <tr>
            <th>Add Genre</th>
          </tr>
        </tbody>
      </table>
        <GenreDropdown value = {masterGames[0].game}/>
      </div>

      );
    }


}

export default EditGenreTable;
