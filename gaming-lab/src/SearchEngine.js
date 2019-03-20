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


//TODO can i consolidate between console and playable mode bc they have basically same fields?
interface Console {
  console: String,
  id: number

}

interface PlayableMode {
  mode: String,
  id: number
}


class SearchEngine extends Component {
  constructor(props) {
    super(props);
    this.state = {
      games: [],
      consoles: [],
      ratings:[],
      modes: [],
      isSearch: false,
      key: null,
      checkedOut: null,
      digital: null,
      console_id: -1,
      mode_id: -1,
      rating:'NONE',


    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleKey = this.handleKey.bind(this);
    this.handleConsole = this.handleConsole.bind(this);
    this.handleMode = this.handleMode.bind(this);
    this.handleRating = this.handleRating.bind(this);
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/consoles').then(response => response.json())
    .then(data => this.setState({consoles: data})).catch(console.log("could not retrieve consoles"));

    fetch('http://localhost:8080/game/modes').then(response => response.json())
    .then(data => this.setState({modes: data})).catch(console.log("could not retrieve playable modes"));

    fetch('http://localhost:8080/game/ratings').then(response => response.json())
    .then(data => this.setState({ratings: data})).catch(console.log("could not retrieve rating"));
  }

  handleSubmit(e) {
    console.log("what is rating: " + this.state.rating);

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
        isDigital: this.state.digital,
        rating: this.state.rating,
      },
      console: {
        id: this.state.console_id,
      },
      mode: {
        id: this.state.mode_id,
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

  handleMode(e) {
    this.setState({mode_id: e.target.value});
  }

  handleRating(e) {
    this.setState({rating: e.target.value});
  }


  render() {

    const {games, isSearch, consoles, modes, ratings} = this.state;
    const gameList = isSearch === false ? null :
    <GameTable value = {games}/>

    const consoleMap = consoles.map((c : Console) => {
      return(
        <div key={c.id}>
        <input type = 'radio' value = {c.id} name="console" onChange={this.handleConsole}/ >{c.console}
        </div>
      );
    });

    const modeMap = modes.map((m : PlayableMode) => {
      return(
        <div key = {m.id}>
          <input type = 'radio' value = {m.id} name= "mode" onChange={this.handleMode} />{m.mode}
        </div>
      );
    });

    const ratingMap = ratings.map((r) => {
      if(r != 'NONE') {
      return(
        <div>
          <input type = "radio" value={r} name = "rating" onChange={this.handleRating} /> {r}
          </div>
      );
    }
    });

    return(
      <div>
        <form onSubmit={this.handleSubmit}>
          <input type = 'text' value={this.state.key} onChange={this.handleKey}/>
          <input type = 'submit' value = "Search"/>
          <h3>Consoles</h3>
          {consoleMap}
          <h3>Playable Modes</h3>
          {modeMap}
          <h3>Rating</h3>
          {ratingMap}
        </form>
       {gameList}
     </div>
    );
  }

}

export default SearchEngine;
