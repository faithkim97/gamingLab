import React, { Component } from 'react';
import AdminGameEntry from './AdminGameEntry';

function showGameTable(gameMap) {
 return(<table>
   <tbody>
     <tr>
     <th>ID</th>
     <th>Title</th>
     <th>Genre</th>
     <th>Console</th>
     <th>Rating</th>
     <th>Playable Modes</th>
     <th>Checked Out</th>
     <th>Digital</th>
     <th>Description</th>
     <th></th>
   </tr>
   </tbody>
 {gameMap}
 </table>);
}

class AdminGameTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      games: [],
      showGames: false,
    };
    this.handleClick = this.handleClick.bind(this);
    this.handleShowGames = this.handleShowGames.bind(this);
  }//endcon

  handleClick() {
    console.log("hello");
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/games').then(response => response.json())
    .then(data => this.setState({games: data})).catch(console.log("could not retrieve games"));
  }

  handleShowGames(e) {
    e.preventDefault();
    const newValue = this.state.showGames;
    this.setState({showGames: !newValue});
  }

  render() {
    const {games, showGames} = this.state;
    const gameMap = games.map(g => {
      return(
        <AdminGameEntry value = {g} onClick={this.handleClick}/>
      );
    });

    const gameTable = showGames ? showGameTable(gameMap) : null;
    return(
      <div>
      <button onClick={this.handleShowGames}>Games</button>
      {gameTable}
      </div>
    );
  }//endrender

}
export default AdminGameTable;
