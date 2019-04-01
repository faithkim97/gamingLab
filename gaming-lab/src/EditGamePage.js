import React, { Component } from 'react';
import EditGenreTable from './EditGenreTable';
import EditModeTable from './EditModeTable';
import EditConsole from './EditConsole';
import EditGameForm from './EditGameForm';
import DeleteGame from './DeleteGame';

class EditGamePage extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    //passing a list of master games set by id
    const masterGames = this.props.value;
    const game = masterGames[0];
    return(
      <div>
        Edit Game:
        <EditGameForm value={game}/>
        Genre:
        <EditGenreTable value = {masterGames} />
        Playable Modes:
        <EditModeTable value = {masterGames} />
        Consoles:
        <EditConsole value = {masterGames} />
        <DeleteGame value ={game.game} />
      </div>


    );


  }

}

export default EditGamePage;
