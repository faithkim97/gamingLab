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

interface Console {
  console: String,
  id: number

}




class SearchEngine extends Component {
  constructor(props) {
    super(props);
    this.state = {
      games: [],
      consoles: [],
      isSearch: false,
      key: null,
      checkedOut: null,
      digital: null,
      console_id: -1,


    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleKey = this.handleKey.bind(this);
    this.handleConsole = this.handleConsole.bind(this);
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/consoles').then(response => response.json())
    .then(data => this.setState({consoles: data})).catch(console.log("could not retrieve consoles"));
  }

  handleSubmit(e) {
    console.log("console id: " + this.state.console_id);
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
      console: {
        id: this.state.console_id,
      }
    })
    }).then(response => response.json())
    .then(data => this.setState({games: data, isSearch: true})).catch(function() {console.log("error")});
  }

  handleKey(e) {
    this.setState({key: e.target.value});
  }

  handleConsole(e) {
    this.setState({console_id: e.target.value});
  }


  render() {
    const {games, isSearch, consoles} = this.state;
    const gameList = isSearch === false ? null :
    <GameTable value = {games}/>
    const consoleMap = consoles.map((c : Console) => {
      return(
        <div key={c.id}>
        <input type = 'radio' value = {c.id} onChange={this.handleConsole}/ >{c.console}
        </div>
      );
    });

    console.log(consoleMap);


    return(
      <div>
        <form onSubmit={this.handleSubmit}>
          <input type = 'text' value={this.state.key} onChange={this.handleKey}/>
          <input type = 'submit' value = "Search"/>
          {consoleMap}
        </form>
       {gameList}
     </div>
    );
  }

}

export default SearchEngine;
