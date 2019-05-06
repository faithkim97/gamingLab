import React from 'react';
import {Button} from 'react-bootstrap';

function GameEntry(props) {
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
  const seen = new Set();
  //I think this prints repeitive mapping
  //the includes doesn't work
  games.map(g=>{
    if(g.genreMap != null && !seen.has(g.genreMap.genre.genre)) {
      seen.add(g.genreMap.genre.genre);
      genres.push(" " + g.genreMap.genre.genre);
    }

    if(g.modeMap != null && !seen.has(g.modeMap.playableMode.mode)) {
      seen.add(g.modeMap.playableMode.mode);
      modes.push(" " + g.modeMap.playableMode.mode);
    }
  });
  // console.log(genres);

  const url = "/admin/editgame/gameId="+masterGame.game.id;

  return(
    <tbody>
  <tr>
    {admin ? (<td>{masterGame.game.id}</td>) : (null)}
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
    {admin ? (<td>{masterGame.game.quantity}</td>) : (null)}
    <td>{masterGame.game.description}</td>
    {admin ? (<td><a href ={url} style={{color: "blue"}}><Button style={{backgroundColor: "yellow", color:"black"}}>Edit Game</Button></a></td>) : (null)}
  </tr>
  </tbody>
);
}

export default GameEntry;
