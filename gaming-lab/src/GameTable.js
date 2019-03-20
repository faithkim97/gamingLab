import React, { Component } from 'react';
import GameEntry from './GameEntry';
import './GameTable.css';

class GameTable extends Component {
  constructor(props) {
    super(props);
  }


  render() {
    const gameMap = this.props.value.map((game) => {
      return (
        <GameEntry value={game} />
      );
    });
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
