import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import SearchEngine from './SearchEngine';
import HomePage from './HomePage';
import * as serviceWorker from './serviceWorker';
import Admin from './Admin'

//ReactDOM.render(<AdminGameTable admin=true />, document.getElementById('root'));
// ReactDOM.render(<SearchEngine admin={false} />, document.getElementById('root'));
ReactDOM.render(<Admin />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
