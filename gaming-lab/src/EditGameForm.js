import React, { Component } from 'react';

class EditGameForm extends Component {
  constructor(props) {
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
           <textarea value ={this.state.description} name="decription" onChange={e => this.changeDescription(e)} />
           <input type = "submit" value = "Update" />
        </form>
      </div>
    );
  }



}//endclass

export default EditGameForm;
