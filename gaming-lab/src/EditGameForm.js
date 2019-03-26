import React, { Component } from 'react';

function createGenreList(masterGames) {
  const genreMaps = [];
  masterGames.map(mg => {
    if (mg.genreMap != null) {
      genreMaps.push(mg.genreMap);
    }
  });
  return genreMaps;
}



function createGenreTable(genreTable) {
  return(
    <table>
      <tbody>
        <tr>
          <th>Map ID</th>
          <th>Current Genre</th>
          <th>Edit Genre To:</th>
          <th></th>
        </tr>
        {genreTable}
      </tbody>
    </table>
  );
}

class EditGameForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      genre: '',
      genres: new Array(this.props.value.length),
    };
    this.changeGenre = this.changeGenre.bind(this);
    this.handleUpdate = this.handleUpdate.bind(this);
  }

  editGenre(e) {
    console.log('edit genre: ' + e.target);
    // genres = this.state.genres;
    // genres.push(e.target);
    // this.setState({genres: genres});
  }

  componentDidMount() {
    const genres = [];
    this.props.value.forEach(g=>{
      if(g.genreMap != null) {
        genres.push(g.genreMap.genre.genre);
      }
    });

    this.setState({genres: genres});
  }

  changeGenre(e) {
    const genre = this.state.genre;
    const newGenre = genre+e.target.value;

    this.setState({genre:e.target.value });
    // console.log(this.state.genre);
  }

  handleUpdate(e){
    e.preventDefault();
    const genres = this.state.genres;
    const genre = '';
    genres.forEach(g => genre += g);
    console.log(genres);


  }

  render() {
    //passing a list of master games set by id
    const masterGames = this.props.value;
    const game = masterGames[0];
    const genreList = createGenreList(masterGames);
    const genreEntry = genreList.map((gm,i) => {
        return(
          <tr>
            <td>{gm.id}</td>
            <td>{gm.genre.genre}</td>
            <td><input type = "text" value={this.state.genres[i]} onChange={this.changeGenre} /></td>
            <td><button>Delete</button></td>
          </tr>
      );
    });

    const genreTable = createGenreTable(genreEntry);


    return(
      <div>
        <form onSubmit={this.handleUpdate}>
          Title:
           <input type = "text" value={game.game.title}/>
           {genreTable}
           <input type = "submit" value = "Update" />
        </form>
      </div>


    );


  }

}

export default EditGameForm;
