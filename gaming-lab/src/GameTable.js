import React, { Component } from 'react';
import GameEntry from './GameEntry';
import './GameTable.css';
import SearchEngine from './SearchEngine';

class GameTable extends Component {
  constructor(props) {
    super(props);
  }


  render() {
    const gameMap = this.props.value.map((game : Game) => {
      return (
        <GameEntry value={game} />
      );
    });
    return (
      <table>
        <tbody>
          <tr>
          <th>Title</th>
          <th>Description</th>
          <th>Genre</th>
          <th>Console</th>
          <th>Playable Modes</th>
        </tr>
        </tbody>
      {gameMap}
      </table>
    );
  }
}

export default GameTable;
