import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';
import {Table, Modal, Button} from 'react-bootstrap';
import Admin, {adminFetch} from "./Admin";

class ModeTable extends Component {

  constructor(props) {
    super(props);
    this.state = {
      modes: [],
      showAlert: false,
      idToDelete: -1,
    };
  }

  componentDidMount() {
    fetch('/game/modes').then(response => response.json())
    .then(data => this.setState({modes: data}));
  }

  deleteMode(e, modeId) {
    let url = '/admin/deleteMode?modeId='+modeId;
    adminFetch(url).then(() => {window.location.reload()});
  }

  handleShow(e, modeId) {
    this.setState({
      showAlert: true,
      idToDelete: modeId,
    });
  }

  handleClose() {
    this.setState({ showAlert: false, });
  }

  render() {
    const modes = this.state.modes;
    const modeMap = modes.map(m => {
      return(
        <GameFieldEntry id={m.id} field={m.mode} onClick={e =>this.handleShow(e, m.id)} />
      );
    });

    return(
      <div style={{width:"50%", margin:"0 auto"}}>
        <Table striped bordered hover variant="dark">
          <thead>
            <tr>
              <th>Playable Mode ID</th>
              <th>Genre</th>
              <th></th>
            </tr>
          </thead>
          {modeMap}
        </Table>

        <Modal show={this.state.showAlert} onHide={e=>this.handleClose(e)}>
        <Modal.Header closeButton>
          WARNING
        </Modal.Header>
          <Modal.Body>
            You are about to delete a playable mode. If you do so, then the mapping of this playable mode to all the
            other games will also be erased. Are you sure you want to delete it?
          </Modal.Body>
          <Modal.Footer>
            <Button variant="danger" onClick={e=> this.deleteMode(e, this.state.idToDelete)}>Delete Playable Mode</Button>
            <Button variant="secondary" onClick={e=>this.handleClose(e)}>Nevermind</Button>
          </Modal.Footer>
        </Modal>
      </div>
    );


  }


}

export default ModeTable;
