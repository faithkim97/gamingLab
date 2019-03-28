import React, { Component } from 'react';
import AdminGameEntry from './AdminGameEntry';
import EditGameForm from './EditGameForm';


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
    this.handleEditGame = this.handleEditGame.bind(this);
    this.handleShowGames = this.handleShowGames.bind(this);
    this.editGameForm = null;
  }//endcon

  handleEditGame(masterGames) {
    console.log("game: " + masterGames[0].game.id);
    this.setState({showGames: false});
    this.editGameForm = <EditGameForm value={masterGames}/>
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
        return (<AdminGameEntry admin={this.props.admin} value = {subgames1} onClick={() => this.handleEditGame(subgames1)}/>);

      }
      subgames.push(g);
    })


    // genres.map(g => console.log(g));
    // const gameMap = games.map(g => {
    //   return(
    //     <AdminGameEntry value = {g} onClick={() => this.handleEditGame(g)}/>
    //   );
    // });

    const gameTable = showGames ? showGameTable(gameMap) : null;
    return(
      <div>
      <button onClick={this.handleShowGames}>Games</button>
      {gameTable}
      {this.editGameForm}
      </div>
    );
  }//endrender

}
export default AdminGameTable;
