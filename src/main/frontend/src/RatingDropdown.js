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
    fetch('/game/ratings').then(response => response.json())
    .then(data => this.setState({ratings: data})).catch(console.log("could not retrieve rating"));
  }

  render() {
      const props = this.props;
    const ratingMap = this.state.ratings.map((r) => {
      return(
        <div key={r}>
          <input type = "radio" value={r} name = "rating" onChange={props.onChange} /> {r}
          <Dropdown.Divider/>
          </div>
      );

    });
    return(
      <div>
        <DropdownButton title="Rating" size={props.size} variant={props.variant}>
        {ratingMap}
        </DropdownButton>
      </div>
    );
  }//endrender


}

export default RatingDropdown;
