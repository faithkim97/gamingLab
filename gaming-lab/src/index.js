import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import SearchEngine from './SearchEngine';
import HomePage from './HomePage';
import Admin from './Admin'
import AddGameForm from './AddGameForm';
import * as serviceWorker from './serviceWorker';

// pages = {
//   "/editGame": <EditGamePage />,
//   "/" : <SearchEngine admin={false} />,
//   "/admin": <SearchEngine admin={true} />
// }

//ReactDOM.render(<AdminGameTable admin=true />, document.getElementById('root'));
// if (window.location.pathname == "/editGame") {
//
// } else {
//
// }
// ReactDOM.render(<SearchEngine admin={true} />, document.getElementById('root'));
// ReactDOM.render(<Admin />, document.getElementById('root'));
ReactDOM.render(<AddGameForm />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
