import React, { Component } from 'react';

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
          </div>
      );

    });
    return(
      <div>
        {ratingMap}
      </div>
    );
  }//endrender


}

export default RatingDropdown;
