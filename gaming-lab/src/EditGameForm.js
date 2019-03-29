import React, { Component } from 'react';

class EditGameForm extends Component {
  constuctor(props) {
    super(props);
    this.game = this.props.value;
    this.state = {
      newTitle:  this.game.title,
      checkedOut: this.game.isCheckedOut,
      digital: this.game.isDigital,
      description: this.game.description,
      quantity: this.game.quantity,
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



}
