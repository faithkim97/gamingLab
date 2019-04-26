import React, { Component } from 'react';
import RatingDropdown from './RatingDropdown';
import {Button, Form, Row, Col} from 'react-bootstrap';
import {adminFetchPost} from './Admin';

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
    let url = 'http://localhost:8080/admin/editgame';
    const {checkedOut, newTitle, digital, description, quantity, rating} = this.state;
    let body = {
      id: this.game.id,
      isCheckedOut: checkedOut,
      title: newTitle,
      isDigital: digital,
      description: this.state.description,
      quantity: quantity,
      rating: rating,
    }

    adminFetchPost(url, body).then(() => window.location.reload());
  }//endupdate


  render() {

    return(
        <div style={{backgroundColor: '#AFE5FF', width:"50%", padding:'1%'}}>
          <border>
          <Form onSubmit={e=>this.handleUpdate(e)} className="block-example border border-secondary">
            <Form.Group>
              <Form.Label>Title</Form.Label>
              <Form.Control size="sm" value={this.state.newTitle} onChange={e=>this.changeTitle(e)}/>
            </Form.Group>

            <Form.Group>
              <Row>
                <Col>
                  <Form.Label>Checked Out</Form.Label>
                  <Form.Check checked={this.state.checkedOut} name="checkedout" onChange={e=>this.changeCheckedOut(e)}/>
                </Col>
                <Col>
                  <Form.Label>Digital</Form.Label>
                  <Form.Check checked={this.state.digital} name="digital" onChange={e=>this.changeDigital(e)}/>
                </Col>
              </Row>
            </Form.Group>
            <Form.Group>
              <Row>
                <Col>
                  <Form.Label>Quantity</Form.Label>
                  <input type="number" value={this.state.quantity} name="quantity" onChange={e=>this.changeQuantity(e)} />
                </Col>
                <Col>
                  <RatingDropdown onChange={e=>this.changeRating(e)} />
                </Col>
              </Row>
            </Form.Group>
            <Form.Group>
              <Form.Label>Description</Form.Label>
              <Form.Control as="textarea" rows="4" value={this.state.description} onChange={e=>this.changeDescription(e)}/>
            </Form.Group>
            <Button variant="warning" type="submit">Update Game Info</Button>
          </Form>
          </border>
        </div>
    )
  }



}//endclass

export default EditGameForm;
