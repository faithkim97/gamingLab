import React, { Component } from 'react';
import {Button} from 'react-bootstrap';

function GameFieldEntry(props) {
  return(
      <tr>
        <td>{props.id}</td>
        <td>{props.field}</td>
        <td><Button variant="danger" onClick={props.onClick}>Delete</Button></td>
      </tr>


  );


}//endclass

export default GameFieldEntry;
