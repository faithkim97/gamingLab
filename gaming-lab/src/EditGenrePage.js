import React, {Component} from 'react';
import GenreTable from './GenreTable';

class EditGenrePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newGenre: '',
    };
  }

  handleChange(e) {
    this.setState({newGenre: e.target.value});
  }

  handleClick(e) {
    fetch('http://localhost:8080/admin/addGenre?genre='+this.state.newGenre);
    window.location.reload();
  }

  render() {

    return(
      <div>
      <h1>Edit Genres </h1>
      <GenreTable />
      <input type = "text" value={this.state.newGenre} onChange={e => this.handleChange(e)}/>
      <button onClick={e => this.handleClick(e)}>Add New Genre </button>
      </div>

    );


  }


}

export default EditGenrePage;
