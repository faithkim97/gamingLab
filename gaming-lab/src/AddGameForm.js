import React, { Component } from 'react';
import GenreDropdown from './GenreDropdown';
import RatingDropdown from './RatingDropdown';
import ModeDropdown from './ModeDropdown';

class AddGameForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: null,
      rating: 'NONE',
      quantity: 1,
      description: null,
      checkedOut: false,
      digital: false,
      console: null,
      genres: [],
      modes: [],

    };
    this.gameAdded = null;
  }

  handleSubmit(e) {
    e.preventDefault();
  }

  changeTitle(e) {
    this.setState({title: e.target.value});
  }

  changeDesc(e){
    this.setState({description: e.target.value});
  }

  changeCheckedOut(e) {
    let c = this.state.checkedOut;
    this.setState({checkedOut: !c});
  }

  changeDigital(e) {
    let d = this.state.digital;
    this.setState({digital: !d});
  }

  changeQuantity(e) {
    this.setState({quantity: e.target.value});
  }

  changeRating(e) {
    this.setState({rating: e.target.value});
  }

  addGenre(genres) {
    this.setState({genres: genres});

  }

  addMode(modes) {
    this.setState({modes: modes});

  }

  render(){
    return(
      <div>
        <form onSubmit={e => this.handleSubmit(e)}>
          Title:
          <input type = "text" name = "title" value={this.state.title} onChange={e=>this.changeTitle(e)} />
          Description:
          <textarea name="description" value={this.state.description} onChange={e=>this.changeDesc(e)} />
          Checked Out:
          <input type = "checkbox" checked = {this.state.checkedOut} name = "checkedout" onChange={e => this.changeCheckedOut(e)}/>
          Digital:
          <input type = "checkbox" checked = {this.state.digital} name="digital" onChange={e=> this.changeDigital(e)}/>
          Quantity:
          <input type = "number" value = {this.state.quantity} name="quantity" onChange={e => this.changeQuantity(e)} />
          Rating:
          <RatingDropdown onChange={e => this.changeRating(e)} useId={false}/>
          Genre:
          <GenreDropdown onAdd={e => this.addGenre(e)} useId={false} editMode={false} onAdd={e=>this.addGenre(e)}/>
          <ModeDropdown onAdd={e=>this.addMode(e)} useId={false} editMode={false} onAdd={e=>this.addMode(e)}/>
        </form>
      </div>



    );

  }//endrender



}

export default AddGameForm;
