import React, { Component } from 'react';
import {Dropdown, DropdownButton} from 'react-bootstrap';

function GameFieldRadioMenu(props) {
  const field = props.field;
  const menu = field.map( f => {
    return(
      <div key = {f.id}>
          <Dropdown.Item><input type = 'radio' value = {f.id} name = {props.type} onChange={props.onChange} />
        { props.type === "console" ? (f.console ): (f.mode)}</Dropdown.Item>
      </div>
    )
  });

  menu.push(
    <div>
      <input type = 'radio' value = {-1} name = {props.type} onChange={props.onChange} />
      None
    </div>
  );

  return (
      <DropdownButton title={props.name}>
          {menu}
      </DropdownButton>
  );


}

export default GameFieldRadioMenu;
