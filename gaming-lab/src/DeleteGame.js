import React, { Component } from 'react';
import {Button} from 'react-bootstrap';

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
        <Button variant="danger" onClick={e => this.handleDelete(e)}>
          Delete Game
        </Button>
      </div>
    );

  }

}

export default DeleteGame;
