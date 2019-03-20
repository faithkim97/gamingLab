import React, { Component } from 'react';

function GameEntry(props) {
  const systemConsole = props.value.consoleMap == null ? 'N/A'
        : props.value.consoleMap.console.console;
  const genre = props.value.genreMap == null ? 'N/A' : props.value.genreMap.genre.genre;
  const mode = props.value.modeMap == null ? 'N/A' : props.value.modeMap.playableMode.mode;

  return(
    <tr>
      <td> {props.value.game.title} </td>
      <td>{genre}</td>
      <td>{systemConsole}</td>
      <td>{props.value.game.rating}</td>
      <td> {mode} </td>
      <td> {props.value.game.description}</td>
    </tr>
  );
}

export default GameEntry;
