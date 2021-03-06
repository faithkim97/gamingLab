import React, { Component } from 'react';
import GameTable from './GameTable';
import GameFieldRadioMenu from './GameFieldRadioMenu';
import RatingDropdown from './RatingDropdown';
import BooleanOptions from './BooleanOptions';
import {InputGroup, FormControl,Nav,Navbar, Form, Button} from 'react-bootstrap';


class SearchEngine extends Component {
  constructor(props) {
    super(props);
    this.state = {
      games: [],
      consoles: [],
      ratings:[],
      modes: [],
      isSearch: false,
      key: null,
      checkedOut: null,
      digital: null,
      console_id: -1,
      mode_id: -1,
      rating:'NONE',
    };

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    fetch('/game/consoles').then(response => response.json())
    .then(data => this.setState({consoles: data})).catch(console.log("could not retrieve consoles"));

    fetch('/game/modes').then(response => response.json())
    .then(data => this.setState({modes: data})).catch(console.log("could not retrieve playable modes"));

    fetch('/game/ratings').then(response => response.json())
    .then(data => this.setState({ratings: data})).catch(console.log("could not retrieve rating"));
  }

  handleSubmit(e) {
    e.preventDefault();

    this.setState({isSearch: true});
    fetch('/game/findgame',
    {method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      keyword:this.state.key,
      game: {
        isCheckedOut: this.state.checkedOut,
        isDigital: this.state.digital,
        rating: this.state.rating,
      },
      console: {
        id: this.state.console_id,
      },
      modes: [{
        id: this.state.mode_id,
      }],

    })
    }).then(response => response.json())
    .then(data => this.setState({games: data, isSearch: true})).catch(function() {console.log("error")});

  }

  handleKey(e) {
    this.setState({key: e.target.value});
  }

  handleConsole(e) {
    this.setState({console_id: e.target.value});
  }

  handleMode(e) {
    this.setState({mode_id: e.target.value});
  }

  handleRating(e) {
    this.setState({rating: e.target.value});
  }

  handleCheckedOut(e) {
    this.setState({
        checkedOut: e.target.value,
    }, () => {console.log(this.state.checkedOut)});
  }

  handleDigital(e) {
    this.setState({digital: e.target.value});
  }




  render() {
    const {games, isSearch, consoles, modes, ratings} = this.state;
    const gameList = isSearch === false ? null :
    <GameTable admin = {this.props.admin} games = {games}/>
    return(
      <div>
        <form onSubmit={e=>this.handleSubmit(e)}>
          {/*<input type = 'text' value={this.state.key} onChange={e => this.handleKey(e)}/>*/}

            <Navbar bg="dark" variant="dark">
            <Nav>
                <Nav.Item><GameFieldRadioMenu variant="warning" size="sm" name="Consoles" field={consoles} type="console" onChange={e =>this.handleConsole(e)} /></Nav.Item>
                &nbsp;
                <Nav.Item><GameFieldRadioMenu size ="sm" variant="info" name="Playable Modes" field = {modes} type="mode" onChange={e => this.handleMode(e)} /></Nav.Item>
                &nbsp;
                <Nav.Item> <RatingDropdown variant="warning" size="sm" onChange={e => this.handleRating(e)} /></Nav.Item>
                &nbsp;
                <Nav.Item><BooleanOptions size="sm" variant="info" title="Checked Out?" name="checkedOut" onChange={e => this.handleCheckedOut(e)} /></Nav.Item>
                &nbsp;
                <Nav.Item> <BooleanOptions variant="warning" size="sm" title="Digital" name = "digital" onChange={e => this.handleDigital(e)} />
                </Nav.Item>

            </Nav>
                &nbsp;
                <InputGroup size="sm">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="inputGroup-sizing-sm">Keywords</InputGroup.Text>
                    </InputGroup.Prepend>
                    <Form inline>
                        <FormControl width="50%" value={this.state.key}
                                     onChange={e => this.handleKey(e)} aria-label="Small" aria-describedby="inputGroup-sizing-sm" />
                    </Form>
                    &nbsp;
                    <Button type ="search" style={{backgroundColor:'pink', color:'purple'}}>Search</Button>
                </InputGroup>

            </Navbar>


        </form>

       {gameList}
     </div>
    );
  }

}

export default SearchEngine;
