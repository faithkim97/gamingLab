import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import SearchEngine from './SearchEngine';
import EditGamePage from './EditGamePage';
import AddGameForm from './AddGameForm';

function Search(admin) {
  return( <SearchEngine admin={admin} /> );
}

function Home() {
  return (<h1> Hello World! </h1>);
}


function AppRouter() {
  return(
    <Router>
      <li>
        <Link to="/">Home</Link>
      </li>
      <li>
        <Link to="/search">Search</Link>
      </li>
      <li>
        <Link to = "/admin">Admin</Link>
      </li>

      <li>
        <Link to = "/addgame">Add Game</Link>
      </li>


      <Route path="/" component={Home} />
      <Route path="/search" component={()=>Search(false)} />
      <Route path="/admin" component={()=>Search(true)} />
      <Route path="/editgame/:gameId" component={EditGamePage} />
      <Route path = "/addgame" component={AddGameForm} />
    </Router>

  );


}//endfxn


export default AppRouter;
