import React, { Component } from 'react';

class EditGenreEntry extends Component {
  constructor(props) {
    super(props);
    this.state = {
      value: null,
      gameId: this.props.value.game.id,
    };
    this.handleChange = this.handleChange.bind(this);
  }

  //TODO create onDelete(e)

  handleChange(e) {
    this.setState({value: e.target.value});
  }

  render() {

    const genreMap = this.props.value.genreMap;

    return(
      <tr>
        <td>{genreMap.id}</td>
        <td>{genreMap.genre.genre}</td>
        <td><button onClick={this.props.onClick}>Delete</button></td>
      </tr>


    );

  }

}//endclass

export default EditGenreEntry;
