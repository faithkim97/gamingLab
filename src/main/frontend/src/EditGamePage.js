import React, { Component } from 'react';
import EditGenreTable from './EditGenreTable';
import EditModeTable from './EditModeTable';
import EditConsole from './EditConsole';
import EditGameForm from './EditGameForm';
import DeleteGame from './DeleteGame';
import {Row} from 'react-bootstrap';

class EditGamePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      masterGames: [],
    };
  }

  componentDidMount() {
    const {gameId} = this.props.match.params;
    fetch('/game/masterGamesByGameId?gameId='+gameId).then(response => response.json())
    .then(data => this.setState({masterGames: data}));
  }

  render() {

    //passing a list of master games set by id
    const masterGames = this.state.masterGames;
    const game = masterGames[0];
    if ( game != null) {
      return(
        <div>
            <DeleteGame value ={game.game} />
            <Row>
          <EditGameForm value={game}/>
          <EditGenreTable value = {masterGames}/>
          <EditModeTable value = {masterGames} />
          <EditConsole value = {masterGames} />
            </Row>
        </div>

      );
    }
      return (null);

  }

}

export default EditGamePage;
