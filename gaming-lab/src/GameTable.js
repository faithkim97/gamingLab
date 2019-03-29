import React, { Component } from 'react';
import GameEntry from './GameEntry';
import './GameTable.css';

class GameTable extends Component {
  constructor(props) {
    super(props);
  }


  render() {
    const games = this.props.games;
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


    return (
      <table>
        <tbody>
          <tr>
          <th>Title</th>
          <th>Genre</th>
          <th>Console</th>
          <th>Rating</th>
          <th>Playable Modes</th>
          <th>Description</th>
        </tr>
        </tbody>
      {gameMap}
      </table>
    );
  }
}

export default GameTable;
