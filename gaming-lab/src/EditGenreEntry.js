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

  handleClickChange(e) {

    e.preventDefault();
    // console.log(this.state.gameId);
    const gameId = 14;

    //IT'S WORKING AHHH
    fetch('http://localhost:8080/admin/mapGenreByGameId?gameId='+gameId+"&genreTitle="+
    "war")
  }

  render() {

    const genreMap = this.props.value.genreMap;

    return(
      <tr>
        <td>{genreMap.id}</td>
        <td>{genreMap.genre.genre}</td>
        <td><input type = "text" value = {this.state.value} onChange={this.handleChange}/>
        <button onClick={this.handleClickChange}>Change Genre </button></td>

        <td><button>Delete</button></td>
      </tr>


    );

  }

}//endclass

export default EditGenreEntry;
