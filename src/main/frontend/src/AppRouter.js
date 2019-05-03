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
import LoginPage from './LoginPage';
import Fonts from './Fonts.css';
import About from './About';

function Search(admin) {
  return(
    <div>
        {admin ? (null) : <HomeNav active="/game/search" />}
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
        <HomeNav active="/home" />
        <Carous />

        </div>
    );
}

function HomeNav(props) {
    return(
        <Nav fill variant="tabs" defaultActiveKey={props.active} style={{fontFamily: "Share Tech Mono, monospace"}}>
            <Nav.Item>
                <Nav.Link href="/home">Home</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link href="/game/search">Find Games</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link href="/game/about">About</Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link href="/admin">Admin</Nav.Link>
            </Nav.Item>
        </Nav>
    );
}

function Carous() {
    return(
        <Carousel>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.pexels.com/photos/687811/pexels-photo-687811.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                    alt="First slide"
                    style={{height:"750px"}}
                />
                <Carousel.Caption>
                    <h3 style={{fontFamily: "Montserrat"}}>Play the PS4 at the Gaming Lab</h3>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.pexels.com/photos/371924/pexels-photo-371924.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                    alt="Third slide"
                    style={{height:"750px"}}
                />

                <Carousel.Caption>
                    <h3 style={{fontFamily: "Montserrat"}}>Play Mario Kart 8</h3>
                    <p style={{fontFamily:"Montserrat"}}>On the Nintendo Switch in the Gaming Lab</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.pexels.com/photos/139038/pexels-photo-139038.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                    alt="Third slide"
                    style={{height:"750px"}}
                />

                <Carousel.Caption>
                    <h3 style={{fontFamily:"Montserrat"}}>Play Xbox One at the Gaming Lab</h3>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>

    );
}

function AboutGamingLab() {
    return(
        <div>
            <HomeNav active="/game/about"/>
            <About />
        </div>
    );
}


function AppRouter() {
  return(
      <div>
      <h1 className="text-center" style={{fontFamily:"Share Tech Mono, monospace", fontSize:"70px"}}><b>The Gaming Lab At Smith College</b></h1>
    <Router>
      <Route path="/" component={Home} />
      <Route path="/admin" component={AdminPage}/>
      <Route path="/admin/editgenre" component={EditGenrePage} />
      <Route path="/admin/editconsole" component={EditConsolePage} />
      <Route path="/admin/editmode" component={EditModePage} />
      <Route path="/game/search" component={()=>Search(false)} />
      <Route path="/admin/search" component={()=>Search(true)} />
      <Route path = "/admin/addgame" component={AddGameForm} />
      <Route path = "/admin/editgame/gameId=:gameId" component = {EditGamePage} />
      <Route path="/login" component={LoginPage}/>
      <Route path="/game/about" component={AboutGamingLab} />
    </Router>
    </div>

  );


}//endfxn


export default AppRouter;
