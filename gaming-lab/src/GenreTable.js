import React, {Component} from 'react';
import GameFieldEntry from './GameFieldEntry';
import {Table} from 'react-bootstrap';

class GenreTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      genres: [],
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/genres').then(response => response.json())
    .then(data => this.setState({genres: data}));
  }

  deleteGenre(e, genreId) {
    fetch('http://localhost:8080/admin/deleteGenre?genreId='+genreId).then(()=>{window.location.reload()});
  }

  render() {
    const genres = this.state.genres;
    const genreMap = genres.map( g => {
      return(
        <GameFieldEntry id={g.id} field={g.genre} onClick={e=>this.deleteGenre(e, g.id)} />
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
      </div>

    );

  }



}

export default GenreTable;
