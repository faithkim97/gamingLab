import React, { Component } from 'react';
import {Button} from 'react-bootstrap';
import Admin, {adminFetch} from "./Admin";

class DeleteGame extends Component {
  constructor(props) {
    super(props);
  }

  handleDelete(e) {
    let url = 'http://localhost:8080/admin/deleteGame?gameId='+this.props.value.id;
    adminFetch(url).then(() => {window.location.reload();});
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
