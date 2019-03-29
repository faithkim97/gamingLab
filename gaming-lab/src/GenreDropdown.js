import React, { Component } from 'react';

class GenreDropdown extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showMenu: false,
      genres: [],
      pickedGenres: [],
    };

  }

  componentDidMount() {
    fetch('http://localhost:8080/game/genres').then(response => response.json())
    .then(data => this.setState({genres: data})).catch(console.log("could not retrieve genres"));

  }

  handleAddGenre(e, game) {
    e.preventDefault();
    fetch('http://localhost:8080/admin/mapGenreByGameGenreIds?gameId='+game.id+"&genreIds="+this.state.pickedGenres);

  }

  handleGenreCheck(e) {
    e.preventDefault();
    const pickedGenres = this.state.pickedGenres.slice();
    pickedGenres.push(e.target.value);
    this.setState({pickedGenres: pickedGenres});
  }

  showMenu(e) {
    e.preventDefault();
    const showMenu = this.state.showMenu;
    this.setState({showMenu: !showMenu});
  }

  render() {
    const genres = this.state.genres;
    const genreButtons = genres.map(g=>{
      return(
        <div>
        <input type = "checkbox" value ={g.id} onChange={e=>this.handleGenreCheck(e)} />
        {g.genre}
        </div>
      );
    });
    return(
      <div>
        <div>
          <button onClick={e => {this.showMenu(e)}}>Genres</button>
        </div>
        {
          this.state.showMenu ?
          (
            <div className="menu">
              {genreButtons}
            </div>
          )
            :
            (
              null
            )

      }
      <div>
        <button onClick = {e => this.handleAddGenre(e, this.props.value)}>Add Genre</button>
      </div>
      </div>


    );


  }

}

export default GenreDropdown;
