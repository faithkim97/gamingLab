import React, { Component } from 'react';
import GameEntry from './GameEntry';
import './GameTable.css';
import EditGamePage from './EditGamePage';

function showGameTable(gameMap, admin) {
  return(
    <table>
      <tbody>
        <tr>
        {admin ? (<th>ID</th>) : (null)}
        <th>Title</th>
        <th>Genre</th>
        <th>Console</th>
        <th>Rating</th>
        <th>Playable Modes</th>
        {admin ? (<th>Checked Out </th>) : (null)}
        {admin ? (<th>Digital</th>) : (null)}
        {admin ? (<th>Quantity</th>) : (null)}
        <th>Description</th>
      </tr>
      </tbody>
    {gameMap}
    </table>
  );
}

class GameTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showGames: false,
    }
    this.editGamePage = null;
  }

  handleEditGame(masterGames) {
    this.setState({showGames: false});
    this.editGamePage = <EditGamePage value={masterGames}/>
  }


  handleShowGames(e) {
    e.preventDefault();
    const newValue = this.state.showGames;
    this.setState({showGames: !newValue});
  }


  render() {
    const admin = this.props.admin;
    const games = this.props.games;
    const seenIds = new Set([games[0] ? games[0].game.id : null]);
    let subgames = [];
    const gameMap = games.map(g=> {
      if(!seenIds.has(g.game.id)){
        seenIds.add(g.game.id);
        const subgames1 = subgames.slice();
        subgames = [];
        subgames.push(g);
        return (<GameEntry admin={admin} value = {subgames1} onClick={() => this.handleEditGame(subgames1)}/>);

      }
      subgames.push(g);
    });

    const gameTable = showGameTable(gameMap, admin);

    return (
      <div>
        {admin ? (<button onClick={e => this.handleShowGames(e)}>Games</button>) : (null)}
        {gameTable}
        {admin ? (this.editGamePage) : (null)}
      </div>
    );
  }
}

export default GameTable;
