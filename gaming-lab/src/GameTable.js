import React, { Component } from 'react';
import GameEntry from './GameEntry';
import './GameTable.css';
import SearchEngine from './SearchEngine';

//TODO model after shopping list
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
