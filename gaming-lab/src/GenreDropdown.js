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

  handleClickAdd(e) {
    const onAdd = this.props.onAdd;
    onAdd(this.state.pickedGenres);
  }

  handleGenreCheck(e) {
    const pickedGenres = this.state.pickedGenres.slice();
    pickedGenres.push(e.target.value);
    this.setState({pickedGenres: pickedGenres});
    if(!this.props.editMode) {
      const onAdd = this.props.onAdd;
      onAdd(this.state.pickedGenres);
    }
  }

  showMenu(e) {
    e.preventDefault();
    const showMenu = this.state.showMenu;
    this.setState({showMenu: !showMenu});
  }

  render() {
    const genres = this.state.genres;
    const useId = this.props.useId;
    const genreButtons = genres.map(g=>{
      return(
        <div>
        <input type = "checkbox" value ={useId ? g.id : g.genre} onChange={e=>this.handleGenreCheck(e)} />
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
      { this.props.editMode ?
        (<div>
          <button onClick={e=>this.handleClickAdd(e)}>Add Genre</button>
        </div>)
        :
        (null)
      }
      </div>




    );


  }

}

export default GenreDropdown;
