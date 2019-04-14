import React, { Component } from 'react';
import {Dropdown, DropdownButton} from 'react-bootstrap';

class RatingDropdown extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ratings: [],
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/ratings').then(response => response.json())
    .then(data => this.setState({ratings: data})).catch(console.log("could not retrieve rating"));
  }

  render() {
    const ratingMap = this.state.ratings.map((r) => {
      return(
        <div key={r}>
          <input type = "radio" value={r} name = "rating" onChange={this.props.onChange} /> {r}
          <Dropdown.Divider/>
          </div>
      );

    });
    return(
      <div>
        <DropdownButton title="Rating">
        {ratingMap}
        </DropdownButton>
      </div>
    );
  }//endrender


}

export default RatingDropdown;
