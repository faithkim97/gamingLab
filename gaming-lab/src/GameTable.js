import React, { Component } from 'react';
import GameEntry from './GameEntry';
import './GameTable.css';

//TODO model after shopping list
class GameTable extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    const gameMap = this.props.value.map( g => {
      return (
        <GameEntry value={g} />
      );
    });
    return (
      <table>
        <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Genre</th>
        <th>Console</th>
        <th>Playable Modes</th>
      </tr>
      {gameMap}
      </table>
    );
  }
}

export default GameTable;
