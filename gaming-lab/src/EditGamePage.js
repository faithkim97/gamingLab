import React, { Component } from 'react';
import EditGenreTable from './EditGenreTable';
import EditModeTable from './EditModeTable';
import EditConsole from './EditConsole';
import EditGameForm from './EditGameForm';
import DeleteGame from './DeleteGame';

class EditGamePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      masterGames: [],
    };
  }

  componentDidMount() {
    const {gameId} = this.props.match.params;
    fetch('http://localhost:8080/game/masterGamesByGameId?gameId='+gameId).then(response => response.json())
    .then(data => this.setState({masterGames: data}));
  }

  render() {
    //passing a list of master games set by id
    const masterGames = this.state.masterGames;
    const game = masterGames[0];
    if ( game != null) {
      return(
        <div>
          Edit Game:
          <EditGameForm value={game}/>
          Genre:
          <EditGenreTable value = {masterGames}/>
          Playable Modes:
          <EditModeTable value = {masterGames} />
          Consoles:
          <EditConsole value = {masterGames} />
          <DeleteGame value ={game.game} />
        </div>

      );
    }
      return (null);

  }

}

export default EditGamePage;
