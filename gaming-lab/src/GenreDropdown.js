import React, { Component } from 'react';


function removeFromPickedGenres(itemToRemove, genres) {
    for (let i = 0; i < genres.length; i++) {
      if (itemToRemove.id == genres[i].id) {
        genres.splice(i,1);
      }
    }

    return genres;
}

class GenreDropdown extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showMenu: false,
      genres: [],
      pickedGenres: [],
      checkedMap: {},
    };

  }

  componentDidMount() {
    fetch('http://localhost:8080/game/genres').then(response => response.json())
    .then(data => this.setState({genres: data},()=>{
      const checkedMap = {};
      const genres = this.state.genres;
      genres.forEach(g =>{
        checkedMap[g.id] = false;
      });
      this.setState({checkedMap: checkedMap});
    }))

  }

  handleClickAdd(e) {
    const onAdd = this.props.onAdd;
    if (this.props.useId) {
      const genreIds = [];
      this.state.pickedGenres.forEach(g => {
        genreIds.push(g.id)
      });
      onAdd(genreIds);
    } else{
      console.log(onAdd);
      onAdd(this.state.pickedGenres);

    }

  }

  handleGenreCheck(e, genre) {
    const checkedMap = this.state.checkedMap;
    //check that current input is false. if it is, then when we clicked it, we need to make it true
    checkedMap[genre.id] = !e.target.checked == false ? true : false;
    this.setState({checkedMap: checkedMap});
    if (!e.target.checked) {
      const pickedGenres = removeFromPickedGenres(genre, this.state.pickedGenres);
      this.setState({pickedGenres: pickedGenres});
    } else {
      const pickedGenres = this.state.pickedGenres.slice();
      pickedGenres.push(genre);
      this.setState({
        pickedGenres: pickedGenres,
      }, () =>{
        if(!this.props.editMode) {
          const onAdd = this.props.onAdd;
          onAdd(this.state.pickedGenres);
        }
      });
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
    const genreButtons = genres.map((g,i)=>{
      return(
        <div>
        <input type = "checkbox" checked={this.state.checkedMap[g.id]} value ={useId ? g.id : g} onChange={(e)=>this.handleGenreCheck(e, g)} />
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
          <button onClick={e=>this.handleClickAdd(e)}>Add Genre(s)</button>
        </div>)
        :
        (null)
      }
      </div>




    );


  }

}

export default GenreDropdown;
