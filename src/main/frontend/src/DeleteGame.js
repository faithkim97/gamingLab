import React, { Component } from 'react';
import {Modal, Button} from 'react-bootstrap';
import Admin, {adminFetch} from "./Admin";

class DeleteGame extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showAlert: false,
    }
  }

  handleDelete(e) {
    let url = '/admin/deleteGame?gameId='+this.props.value.id;
    adminFetch(url).then(() => {window.location.reload();});
  }

  handleShow(e) {
    this.setState({
      showAlert:true,
    });
  }

  handleClose(e) {
    this.setState({showAlert: false});
  }

  render() {
    return(
      <div>
        <Button variant="danger" onClick={e => this.handleShow(e)}>
          Delete Game
        </Button>
        <Modal show={this.state.showAlert} onHide={e=>this.handleClose(e)}>
          <Modal.Header closeButton>
            WARNING
          </Modal.Header>
          <Modal.Body>
            You are about to delete a game. Are you sure you want to delete?
          </Modal.Body>
          <Modal.Footer>
            <Button variant="danger" onClick={e=>this.handleDelete(e)}>Delete Game</Button>
            <Button variant="secondary" onClick={e=>this.handleClose(e)}>Nevermind</Button>
          </Modal.Footer>
        </Modal>
      </div>
    );

  }

}

export default DeleteGame;
