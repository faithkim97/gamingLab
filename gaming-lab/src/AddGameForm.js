import React, { Component } from 'react';
import GenreDropdown from './GenreDropdown';
import RatingDropdown from './RatingDropdown';
import ModeDropdown from './ModeDropdown';
import ConsoleDropdown from './ConsoleDropdown';
import {Form, Row, Col} from 'react-bootstrap';
import  {adminFetch, adminFetchPost} from "./Admin";


//TODO put in console dropdwon
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
      console: -1,
      genres: [],
      modes: [],

    };
  }


  handleSubmit(e) {
    e.preventDefault();
    const {title, checkedOut, digital, quantity, description, rating,genres, modes, console} = this.state;
    let url = 'http://localhost:8080/admin/addgame';
    // fetch('http://localhost:8080/admin/addgame',
    // {
    //   method: "POST",
    //   headers: {
    //   Accept: "application/json",
    //   "Content-Type": "application/json"},
    //   body: JSON.stringify({
    //     game: {
    //       isCheckedOut: checkedOut,
    //       title: title,
    //       isDigital: digital,
    //       description: description,
    //       quantity: quantity,
    //       rating: rating,
    //     },
    //
    //     genres: genres,
    //     modes: modes,
    //     console: {
    //       id: console,
    //     },
    //   })
    //
    // }).then(() =>{window.location.reload()});
    let body ={
      game: {
        isCheckedOut: checkedOut,
        title: title,
        isDigital: digital,
        description: description,
        quantity: quantity,
        rating: rating,
      },

      genres: genres,
      modes: modes,
      console: {
        id: console,
      },
    };
    adminFetchPost('http://localhost:8080/admin/addgame', body);
    // adminFetch(url);

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

  changeConsole(console) {
    this.setState({console: console});
  }


  render(){
    return(
      <div style={{backgroundColor: "white", width:"60%", margin:"0 auto", padding:"1%"}}>
        <h1 style={{textAlign:"center"}}>Add New Game</h1>
        <form onSubmit={e => this.handleSubmit(e)}>
          <Form.Group>
            <Form.Label>Title</Form.Label>
            <Form.Control size ="sm" name="title" value={this.state.title} onChange={e=>this.changeTitle(e)}/>
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
              <input type = "number" value = {this.state.quantity} name="quantity" onChange={e => this.changeQuantity(e)} />
              </Col>
              <Col>
              <RatingDropdown onChange={e => this.changeRating(e)} useId={false}/>
              </Col>
            </Row>

          </Form.Group>
          <Form.Group>
            <Form.Label>Description</Form.Label>
            <Form.Control as="textarea" rows="4" value={this.state.description} onChange={e=>this.changeDesc(e)} />
          </Form.Group>

          <Form.Group>
            <Row>
              <Col>
                <Form.Label>Genres</Form.Label>
                <GenreDropdown onAdd={e => this.addGenre(e)} useId={false} editMode={false} onAdd={e=>this.addGenre(e)}/>
              </Col>
              <Col>
                <Form.Label>Playable Modes</Form.Label>
                <ModeDropdown onAdd={e=>this.addMode(e)} useId={false} editMode={false} onAdd={e=>this.addMode(e)}/>
              </Col>
              <Col>
                <Form.Label>Console</Form.Label>
                <ConsoleDropdown  useId={true} editMode={false} onAdd={e=>this.changeConsole(e)} />
              </Col>
            </Row>
          </Form.Group>
          <input type="submit" value="Add Game"/>
        </form>
      </div>



    );

  }//endrender



}

export default AddGameForm;
