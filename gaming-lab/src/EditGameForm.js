import React, { Component } from 'react';
import RatingDropdown from './RatingDropdown';

class EditGameForm extends Component {
  constructor(props) {
    super(props);
    this.game = this.props.value.game;
    this.state = {
      newTitle:  this.game.title,
      checkedOut: this.game.isCheckedOut,
      digital: this.game.isDigital,
      description: this.game.description == null ? '' : this.game.description,
      quantity: this.game.quantity,
      rating: this.game.rating,
    };
  }

  changeTitle(e) {
    this.setState({newTitle: e.target.value});
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

  changeDescription(e) {
    this.setState({description: e.target.value});
  }

  changeRating(e) {
    this.setState({rating: e.target.value});
  }

  handleUpdate(e) {
    e.preventDefault();
    const {checkedOut, newTitle, digital, description, quantity, rating} = this.state;
    fetch('http://localhost:8080/admin/editgame',
    {
      method: "POST",
      headers: {
      Accept: "application/json",
      "Content-Type": "application/json"},
      body: JSON.stringify({
        id: this.game.id,
        isCheckedOut: checkedOut,
        title: newTitle,
        isDigital: digital,
        description: this.state.description,
        quantity: quantity,
        rating: rating,
      })

    });
  }//endupdate


  render() {
    return(
      <div>
        <form onSubmit={e => this.handleUpdate(e)}>
          Title:
           <input type = "text" value={this.state.newTitle} onChange={e => this.changeTitle(e)}/>
           Checked Out:
           <input type = "checkbox" checked = {this.state.checkedOut} name = "checkedout" onChange={e => this.changeCheckedOut(e)}/>
           Digital:
           <input type = "checkbox" checked = {this.state.digital} name="digital" onChange={e=> this.changeDigital(e)}/>
           Quantity:
           <input type = "number" value = {this.state.quantity} name="quantity" onChange={e => this.changeQuantity(e)} />
           Description:
           <textarea value ={this.state.description} onChange={e => this.changeDescription(e)} />
           Rating:
           <RatingDropdown onChange={e => this.changeRating(e)}/>
           <input type = "submit" value = "Update" />
        </form>
      </div>
    );
  }



}//endclass

export default EditGameForm;
