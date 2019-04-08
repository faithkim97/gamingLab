import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import SearchEngine from './SearchEngine';
import EditGamePage from './EditGamePage';
import AddGameForm from './AddGameForm';
import EditModePage from './EditModePage';
import EditGenrePage from './EditGenrePage';
import EditConsolePage from './EditConsolePage';
import AppRouterStyle from './AppRouterStyle.css';

function Search(admin) {
  return(
    <div>
      <li>
        <a href="/home">Home</a>
      </li>
      <SearchEngine admin={admin} />
    </div>
   );
}

function Admin() {
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

function Home() {
  return (
    <div>
      <h1> Welcome to the Gaming Lab! </h1>
        <li>
          <a href="/game/search">Find Games!</a>
        </li>
        <li>
          <a href="/admin">Admin</a>
        </li>
    </div>
  );
}



function AppRouter() {
  return(
    <Router>
      <Route path="/home" component={Home} />
      <Route path="/admin" component={Admin}/>
      <Route path="/admin/editgenre" component={EditGenrePage} />
      <Route path="/admin/editconsole" component={EditConsolePage} />
      <Route path="/admin/editmode" component={EditModePage} />
      <Route path="/game/search" component={()=>Search(false)} />
      <Route path="/admin/search" component={()=>Search(true)} />
      <Route path = "/admin/addgame" component={AddGameForm} />
      <Route path = "/admin/editgame/gameId=:gameId" component = {EditGamePage} />
    </Router>

  );


}//endfxn


export default AppRouter;
