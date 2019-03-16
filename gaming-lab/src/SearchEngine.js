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
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

    // componentDidMount() {
    //   //TODO change the path
    //   fetch('http://localhost:8080/game/games')
    //  .then(response => response.json())
    //  .then(data => this.setState({games: data, isLoading: false}));
    //
    // }

  handleSubmit(e) {
    this.setState({isSearch: true});
    fetch('http://localhost:8080/game/findgame')
   .then(response => response.json())
   .then(data => this.setState({games: data, isLoading: false}));
  }




  render() {
    const {games, isSearch} = this.state;
    if (!isSearch) {
      return (
        <form onSubmit={this.handleSubmit}>
          <input type = 'text'/>
          <input type = 'submit' value = "Search"/>
        </form>

      );
    }

    return(
      <div>
       <h2>Game List</h2>
        <GameTable value = {games} />
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
