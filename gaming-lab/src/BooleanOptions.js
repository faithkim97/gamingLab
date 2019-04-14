import React, { Component } from 'react';
import {DropdownButton, Dropdown} from 'react-bootstrap';




    function BooleanOptions(props) {
        return (
            <DropdownButton title={props.title}>
               <input type="radio" value={true} name={props.name} onChange={props.onChange}/> Yes
                <Dropdown.Divider/>
                <input type="radio" value={false} name={props.name} onChange={props.onChange}/>No
                <Dropdown.Divider/>
               <input type="radio" value={null} name={props.name} onChange={props.onChange}/>None
            </DropdownButton>

        );


    }


export default BooleanOptions;
