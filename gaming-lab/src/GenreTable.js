import React, {Component} from 'react';
import GameFieldEntry from './GameFieldEntry';
import {Table, Modal,Button} from 'react-bootstrap';
import Admin, {adminFetch} from "./Admin";


class GenreTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      genres: [],
      showAlert: false,
      idToDelete: -1,
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/genres').then(response => response.json())
    .then(data => this.setState({genres: data}));
  }

  //TODO do adminFetch
  deleteGenre(e, genreId) {
    let url = 'http://localhost:8080/admin/deleteGenre?genreId='+genreId;
    adminFetch(url)
        .then(()=>{this.setState({showAlert: false});}).then(() => {window.location.reload();
    });

  }

  handleShow(e, genreId) {
    console.log(genreId);
    this.setState({
      showAlert: true,
      idToDelete: genreId,
    });
  }

  handleClose() {
    this.setState({showAlert: false});
  }

  render() {
    const genres = this.state.genres;
    const genreMap = genres.map( g => {
      return(
        <GameFieldEntry id={g.id} field={g.genre} onClick={e=>this.handleShow(e, g.id)} />
      );
    });

    return(
      <div style={{width:"50%", margin:"0 auto"}}>
        <Table striped bordered hover variant="dark">
          <thead>
            <tr>
              <th>Genre ID</th>
              <th>Genre</th>
              <th></th>
            </tr>
          </thead>
          {genreMap}
        </Table>

        <Modal show={this.state.showAlert} onHide={e=>this.handleClose(e)}>
          <Modal.Header closeButton>
            WARNING
          </Modal.Header>
          <Modal.Body>
              You are about to delete a genre. If you do so, then the mapping of this genre to all the
            other games will also be erased. Are you sure you want to delete it?
          </Modal.Body>
          <Modal.Footer>
            <Button variant="danger" onClick={e=>this.deleteGenre(e, this.state.idToDelete)}>Delete Genre</Button>
            <Button variant="secondary" onClick={e=>this.handleClose(e)}>Nevermind</Button>
          </Modal.Footer>

        </Modal>
      </div>

    );

  }



}

export default GenreTable;
