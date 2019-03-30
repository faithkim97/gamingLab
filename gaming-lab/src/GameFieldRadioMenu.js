import React, { Component } from 'react';

function GameFieldRadioMenu(props) {
  const field = props.field;
  const menu = field.map( f => {
    return(
      <div key = {f.id}>
        <input type = 'radio' value = {f.id} name = {props.type} onChange={props.onChange} />
        { props.type === "console" ? (f.console ): (f.mode)}
      </div>
    )
  });

  menu.push(
    <div>
      <input type = 'radio' value = {-1} name = {props.type} onChange={props.onChange} />
      None
    </div>
  );

  return menu;


}

export default GameFieldRadioMenu;
