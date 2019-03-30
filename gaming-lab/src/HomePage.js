import React, { Component } from 'react';
import SearchEngine from './SearchEngine';

class HomePage extends Component {
  constructor(props) {
    super(props);
    this.searchEngine = null;
  }

  handleClick(e) {
    console.log("value: " +e.target.value);
    this.searchEngine = <SearchEngine admin={e.target.value} />
    console.log(this.searchEngine);
  }

  render() {
    return(
      <div>
        <button value={true} onClick={e => this.handleClick(e)}>Admin</button>
        <button value={false} onClick={e =>this.handleClick(e)}>Student</button>
        {this.searchEngine}
      </div>

    );

  }//endrender

}

export default HomePage;
