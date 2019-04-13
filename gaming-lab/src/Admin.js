import React, { Component } from 'react';
import GameTable from './GameTable';

class Admin extends Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {
    fetch("http://localhost:8080/admin/");
  }

  render() {
    return(
        <div>
          <li>
            <a href="/home">Home</a>
          </li>
          <li>
            <a href="/admin/search">Search Games</a>
          </li>
          <li>
            <a href="/admin/addgame">Add New Game</a>
          </li>
          <div class="dropdown">
            <button class="dropbtn">Edit Game Fields</button>
            <div class="dropdown-content">
              <a href="/admin/editgenre">Genre</a>
              <a href="/admin/editconsole">Console</a>
              <a href="/admin/editmode">Playable Mode</a>
            </div>
          </div>
        </div>
    );

  }

}
export default Admin;
