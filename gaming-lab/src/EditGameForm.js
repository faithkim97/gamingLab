import React, { Component } from 'react';
import EditGenreTable from './EditGenreTable';
import EditModeTable from './EditModeTable';
import EditConsole from './EditConsole';

class EditGameForm extends Component {
  constructor(props) {
    super(props);
    this.handleUpdate = this.handleUpdate.bind(this);
  }


  handleUpdate(e){
    e.preventDefault();

  }

  render() {
    //passing a list of master games set by id
    const masterGames = this.props.value;
    const game = masterGames[0];
    return(
      <div>
        <form onSubmit={this.handleUpdate}>
          Title:
           <input type = "text" value={game.game.title}/>


           <input type = "submit" value = "Update" />
        </form>
        Genre:
        <EditGenreTable value = {masterGames} />
        Playable Modes:
        <EditModeTable value = {masterGames} />
        Consoles:
        <EditConsole value = {masterGames} />
      </div>


    );


  }

}

export default EditGameForm;
