import React, { Component  } from 'react';
import ModeTable from './ModeTable';
import {Form, Button} from 'react-bootstrap';
import Admin, {adminFetch} from "./Admin";

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
    let url = '/admin/addMode?mode='+this.state.newMode;
    adminFetch(url).then(() => {window.location.reload()});
  }

  render() {
    return(
      <div style={{backgroundColor: "white", width:"80%", margin:"0 auto"}}>
        <h1 style={{textAlign:"center"}}>Edit Playable Modes</h1>
        <ModeTable />
        <div style={{width:"30%", margin:"0 auto"}}>
          <Form.Group>
            <Form.Control value={this.state.newMode} onChange={e=>this.handleChange(e)} />
            <Button onClick={e=>this.handleClick(e)}>Add Playable Mode</Button>
          </Form.Group>
        </div>
        {/*<input type = "text" value={this.state.newMode} onChange={e=>this.handleChange(e)} />*/}
      </div>
    );

  }

}

export default EditModePage;
