import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import SearchEngine from './SearchEngine';
import EditGamePage from './EditGamePage';

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


      <Route path="/" component={Home} />
      <Route path="/search" component={()=>Search(false)} />
      <Route path="/admin" component={()=>Search(true)} />
      // <Route path="/admin/editgame/:gameId" component={EditGamePage} />
    </Router>

  );


}//endfxn


export default AppRouter;
