import React, { Component } from 'react';

function AdminGameEntry(props) {
  const games = props.value;
  const admin = props.admin;
  const masterGame = games[0];
  let systemConsole = null;
  //finding mastergame with no null console
  for (let i = 0; i < games.length; i++) {
    if (games[i].consoleMap != null) {
      systemConsole = games[i].consoleMap.console.console;
    }
  }

  const checkedOut = masterGame.game.isCheckedOut ? "true" : "false";
  const isDigital = masterGame.game.isDigital ? "true" : "false";

  const genres = [];
  const modes = [];
  //I think this prints repeitive mapping
  //the includes doesn't work
  games.map(g=>{
    if(g.genreMap != null) {
      genres.push(" " + g.genreMap.genre.genre);
    }

    if(g.modeMap != null && !modes.includes(g.modeMap.playableMode.mode)) {
      modes.push(" " + g.modeMap.playableMode.mode);
    }
  });

  return(
  <tr>
    <td>{masterGame.game.id}</td>
    <td> {masterGame.game.title} </td>
    <td>{genres}</td>
    <td>{systemConsole}</td>
    <td>{masterGame.game.rating}</td>
    <td>{modes}</td>
    {(admin) ?
      <td>{checkedOut}</td>
    : null}
    {(admin) ?
    <td>{isDigital}</td>
    : null}
    <td>{masterGame.game.description}</td>
    <td><button onClick={props.onClick}>Edit Game</button></td>
  </tr>
);
}

export default AdminGameEntry;
