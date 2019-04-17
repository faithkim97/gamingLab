import React, { Component } from 'react';
import GameFieldEntry from './GameFieldEntry';
import {Table, Modal, Button} from 'react-bootstrap';

class ConsoleTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      consoles: [],
      showAlert: false,
      idToDelete: -1,
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/consoles').then(response => response.json())
    .then(data => this.setState({consoles: data}));
  }

  deleteConsole(e, consoleId) {
    console.log(consoleId);
    fetch('http://localhost:8080/admin/deleteConsole?consoleId='+consoleId).then(() => {window.location.reload()});
  }

  handleShow(e, consoleId) {
    this.setState({
      showAlert: true,
      idToDelete: consoleId,
    });
  }

  handleClose() {
    this.setState({showAlert: false});
  }

  render() {
    const consoles = this.state.consoles;
    const consoleMap = consoles.map(c => {
      return(
        <GameFieldEntry id={c.id} field={c.console} onClick={e => this.handleShow(e, c.id)} />
      );
    });

    return(
      <div style={{width:"50%", margin:"0 auto"}}>
        <Table striped bordered hover variant="dark">
          <thead>
            <tr>
              <th>Console ID</th>
              <th>Console</th>
              <th></th>
            </tr>
          </thead>
          {consoleMap}
        </Table>
        <Modal show={this.state.showAlert} onHide={e=>this.handleClose()}>
          <Modal.Header closeButton>
            WARNING
          </Modal.Header>
          <Modal.Body>
            You are about to delete a console. If you do so, then the mapping of this console to all the
            other games will also be erased. Are you sure you want to delete it?
          </Modal.Body>
          <Modal.Footer>
            <Button variant="danger" onClick={e=>this.deleteConsole(e, this.state.idToDelete)}>Delete Console</Button>
            <Button variant="secondary">Nevermind</Button>
          </Modal.Footer>
        </Modal>
      </div>
    );

  }

}

export default ConsoleTable;
