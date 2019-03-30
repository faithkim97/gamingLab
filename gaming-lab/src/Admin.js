import React, { Component } from 'react';
import GameTable from './GameTable';

class Admin extends Component {
  constructor(props){
    super(props);
    this.state = {
      games: [],
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/games').then(response => response.json())
    .then(data => this.setState({games: data})).catch(console.log("could not retrieve games"));
  }

  render() {
    return(
      <div>
        <GameTable admin={true} games={this.state.games}  />
      </div>

    );

  }//endrender


}//endclass
export default Admin;
