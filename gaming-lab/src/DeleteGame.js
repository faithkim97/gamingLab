import React, { Component } from 'react';

class DeleteGame extends Component {
  constructor(props) {
    super(props);
  }

  handleDelete(e) {
    fetch('http://localhost:8080/admin/deleteGame?gameId='+this.props.value.id);
    window.location.reload();
  }

  render() {
    return(
      <div>
        <button onClick={e => this.handleDelete(e)}>
          Delete Game
        </button>
      </div>
    );

  }

}

export default DeleteGame;
