import React, { Component } from 'react';

function GameFieldEntry(props) {
  return(
      <tr>
        <td>{props.id}</td>
        <td>{props.field}</td>
        <td><button onClick={props.onClick}>Delete</button></td>
      </tr>
  );


}//endclass

export default GameFieldEntry;
