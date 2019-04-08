import React, { Component  } from 'react';
import ModeTable from './ModeTable';

class EditModePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newMode: '',
    };
  }

  handleChange(e) {
    this.setState({ newMode: e.target.value });
  }

  handleClick(e) {
    fetch('http://localhost:8080/admin/addMode?mode='+this.state.newMode);
    window.location.reload();
  }

  render() {
    return(
      <div>
        <h1>Edit Playable Modes</h1>
        <ModeTable />
        <input type = "text" value={this.state.newMode} onChange={e=>this.handleChange(e)} />
        <button onClick={e=>this.handleClick(e)}>Add Playable Mode</button>
      </div>
    );

  }

}

export default EditModePage;
