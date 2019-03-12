import React, { Component } from 'react';

function GameEntry(props) {
  return(
    <tr>
      <td> {props.value.title} </td>
      <td> {props.value.description}</td>
      <td> {props.value.genres} </td>
      <td> {props.value.console} </td>
      <td> {props.value.mode} </td>
    </tr>
  );
}

export default GameEntry;
