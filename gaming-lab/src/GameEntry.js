import React, { Component } from 'react';

function GameEntry(props) {
  return(
    <tr>
      <td> {props.value.game.title} </td>
      <td> {props.value.game.description}</td>
      <td>{props.value.game.rating}</td>
      <td>{props.value.genreMap.genre.genre}</td>
      <td> {props.value.mode} </td>
    </tr>
  );
}

export default GameEntry;
