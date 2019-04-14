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
import {Nav, Carousel} from 'react-bootstrap';

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
        <Carous />

        </div>
    );
}

function Carous() {
    return(
        <Carousel>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images5.alphacoders.com/860/thumb-1920-860842.jpg"
                    alt="First slide"
                />
                <Carousel.Caption>
                    <h3>Uncharted: The Lost Legacy</h3>
                    <p>On the PS4 at the Gaming Lab</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://i.imgur.com/ezlIxS8.jpg?fb"
                    alt="Third slide"
                />

                <Carousel.Caption>
                    <h3>Mario Kart 8 Deluxe</h3>
                    <p>On the Nintendo Switch at the Gaming Lab</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://steamcdn-a.akamaihd.net/steam/apps/611660/capsule_616x353.jpg?t=1522898983"
                    alt="Third slide"
                />

                <Carousel.Caption>
                    <h3>Fallout 4 on VR</h3>
                    <p>On HTC Vive at the Gaming Lab</p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>

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
