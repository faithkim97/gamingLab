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
      key: '',
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleKey = this.handleKey.bind(this);
  }

    // componentDidMount() {
    //   //TODO change the path
    //   this.setState({isSearch: true});
    //   fetch('http://localhost:8080/game/findgame')
    //  .then(response => response.json())
    //  .then(data => this.setState({games: data, isSearch: false}));
    //
    // }

  handleSubmit(e) {
    e.preventDefault();
    this.setState({isSearch: true});
    fetch('http://localhost:8080/game/findgame?key='+this.state.key)
   .then(response => response.json())
   .then(data => this.setState({games: data, isSearch: true}));

   console.log(this.state.games);
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


  // {games.map((game: Game) =>
  //    <div key={game.id}>
  //      // {game.game.id} {game.game.title} {game.genreMap.genre.genre}
  //
  //    </div>
  //  )}



  //   return (
  //       // <form onSubmit={handleSubmit}>
  //       // <div>
  //       // <form onSubmit = {handleSubmit}>
  //       //   <input type = 'text' />
  //       //   <input type = "submit" value = "Search" />
  //       // </form>
  //       // <div>
  //       //   <GameTable value={this.state.games} />
  //       // </div>
  //       // </div>
  //
  //
  //
  // );
//endrender
}

export default SearchEngine;
