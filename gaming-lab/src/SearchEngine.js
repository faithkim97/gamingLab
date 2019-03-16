import React, { Component } from 'react';
import GameTable from './GameTable';
/*
Things to create:

a Submit form that contains:
-A search bar (title, desc, genre)
-A radio button option for Console
-radio button option for mode
*/


interface Game {
  game: Array;
  genreMap: Array;
  modeMap: Array;
  consoleMap: Array;
}

class SearchEngine extends Component {
  constructor(props) {
    super(props);
    this.state = {
      games: [],
      isSearch: false,
      key: "stream",
      checkedOut: null,
      digital: null,
      console: "ps4",


    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleKey = this.handleKey.bind(this);
  }

  handleSubmit(e) {
    console.log(this.state.key);
    e.preventDefault();
    this.setState({isSearch: true});
    fetch('http://localhost:8080/game/findgame',
    {method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json"},
    body: JSON.stringify({
      keyword:this.state.key,
      game: {
        isCheckedOut: this.state.checkedOut,
        isDigital: this.state.digital
      },
    })
    }).then(response => response.json())
    .then(data => this.setState({games: data, isSearch: true})).catch(function() {console.log("error")});
  }

  handleKey(e) {
    this.setState({key: e.target.value});
  }

  render() {
    const {games, isSearch} = this.state;
    const gameList = isSearch === false ? null :
    <GameTable value = {games}/>

    return(
      <div>
        <form onSubmit={this.handleSubmit}>
          <input type = 'text' value={this.state.key} onChange={this.handleKey}/>
          <input type = 'submit' value = "Search"/>
        </form>
       {gameList}
     </div>
    );
  }

}

export default SearchEngine;
