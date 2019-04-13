import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import SearchEngine from './SearchEngine';
import EditGamePage from './EditGamePage';
import AddGameForm from './AddGameForm';
import EditModePage from './EditModePage';
import EditGenrePage from './EditGenrePage';
import EditConsolePage from './EditConsolePage';
import Admin from './Admin';
import AppRouterStyle from './AppRouterStyle.css';
import {Nav} from 'react-bootstrap';

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

function AdminPage() {
    return(
       <Admin />
    );

}

function Home() {
  // return (
  //   <div>
  //     <h1> Welcome to the Gaming Lab! </h1>
  //       <li>
  //         <a href="/game/search">Find Games!</a>
  //       </li>
  //       <li>
  //         <a href="/admin">Admin</a>
  //       </li>
  //   </div>
  // );

    return (
        <div>
        <h1 className="text-center">The Gaming Lab At Smith College</h1>
        <Nav fill variant="tabs" defaultActiveKey="/home">
            <Nav.Item>
                <Nav.Link href="/home">Home</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link href="/game/search">Find Games</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link href="/admin">Admin</Nav.Link>
            </Nav.Item>
        </Nav>
        <Image />
        </div>
    );
}

function Image() {
    return(
        <img src ="https://images5.alphacoders.com/860/thumb-1920-860842.jpg"/>
    );
}



function AppRouter() {
  return(
    <Router>
      <Route path="/home" component={Home} />
      <Route path="/admin" component={AdminPage}/>
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
