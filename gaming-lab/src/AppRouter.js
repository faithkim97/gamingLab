import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import SearchEngine from './SearchEngine';
import EditGamePage from './EditGamePage';
import AddGameForm from './AddGameForm';

function Search(admin) {
  return( <SearchEngine admin={admin} /> );
}

function Home() {
  return (<h1> Welcome to the Gaming Lab! </h1>);
}



function AppRouter() {
  return(
    <Router>
      <li>
        <Link to="/home">Home</Link>
      </li>
      <li>
        <Link to="/search">Search</Link>
      </li>
      <li>
        <Link to = "/admin/search">Admin</Link>
      </li>

      <li>
        <Link to = "/admin/addgame">Add Game</Link>
      </li>

      <Route path="/home" component={Home} />
      <Route path="/search" component={()=>Search(false)} />
      <Route path="/admin/search" component={()=>Search(true)} />
      <Route path = "/admin/addgame" component={AddGameForm} />
      <Route path = "/admin/editgame/gameId=:gameId" component = {EditGamePage} />
    </Router>

  );


}//endfxn


export default AppRouter;
