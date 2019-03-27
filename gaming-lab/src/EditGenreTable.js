import React, { Component } from 'react';
import EditGenreEntry from './EditGenreEntry';

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


    render() {
      const masterGames = this.props.value;
      const genreEntries = masterGames.map(mg => {
        if (mg.genreMap != null) {
          return(
            <EditGenreEntry value={mg}/>
          );
        }
      });

      return(
      <table>
        <tbody>
          <tr>
            <th>Map ID</th>
            <th>Current Genre</th>
            <th>Edit Genre To:</th>
            <th></th>
          </tr>
          {genreEntries}
        </tbody>
      </table>

      );
    }


}

export default EditGenreTable;
