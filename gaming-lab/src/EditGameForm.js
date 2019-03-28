import React, { Component } from 'react';
import EditGenreTable from './EditGenreTable';

class EditGameForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      genres: '',
    };
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
           Genre:
           <EditGenreTable value = {masterGames} />
           <input type = "submit" value = "Update" />
        </form>
      </div>


    );


  }

}

export default EditGameForm;
