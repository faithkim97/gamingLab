import React, { Component } from 'react';

function BooleanOptions(props) {
  return(
    <div>
      <input type = "radio" value ={true} name = {props.name} onChange={props.onChange} />Yes
      <input type = "radio" value={false} name = {props.name} onChange={props.onChange} />No
      <input type = "radio" value={null} name = {props.name} onChange={props.onChange} />None
    </div>

  );


}

export default BooleanOptions;
