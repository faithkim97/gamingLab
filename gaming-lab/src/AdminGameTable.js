import React, { Component } from 'react';
import EditGamePage from './EditGamePage';
import GameEntry from './GameEntry';


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
    this.editGamePage = null;
  }//endcon

  handleEditGame(masterGames) {
    this.setState({showGames: false});
    this.editGamePage = <EditGamePage value={masterGames}/>
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
    //TODO don't hardcode 14. set it by the first id in json
    const seenIds = new Set([games[0] ? games[0].game.id : null]);
    let subgames = [];
    const gameMap = games.map(g=> {
      if(!seenIds.has(g.game.id)){
        seenIds.add(g.game.id);
        const subgames1 = subgames.slice();
        subgames = [];
        subgames.push(g);
        return (<GameEntry admin={this.props.admin} value = {subgames1} onClick={() => this.handleEditGame(subgames1)}/>);

      }
      subgames.push(g);
    })

    const gameTable = showGames ? showGameTable(gameMap) : null;
    return(
      <div>
      <button onClick={e => this.handleShowGames(e)}>Games</button>
      {gameTable}
      {this.editGamePage}
      </div>
    );
  }//endrender

}
export default AdminGameTable;
