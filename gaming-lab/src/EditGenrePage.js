import React, {Component} from 'react';
import GenreTable from './GenreTable';
import {Form, Button} from 'react-bootstrap';

class EditGenrePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newGenre: '',
    };
  }

  handleChange(e) {
    this.setState({newGenre: e.target.value});
  }

  handleClick(e) {
    fetch('http://localhost:8080/admin/addGenre?genre='+this.state.newGenre);
    window.location.reload();
  }

  render() {

    return(
      <div style={{backgroundColor: "white", width:"80%", margin:"0 auto"}}>
        <h1 style={{textAlign:"center"}}>Edit Genres</h1>
        <GenreTable />
        <div style={{width:"30%", margin:"0 auto"}}>
          <Form.Group>
            <Form.Control value={this.state.newGenre} onChange={e=>this.handleChange(e)} />
            <Button style={{margin:"0 auto"}} onClick={e => this.handleClick(e)}>Add New Genre</Button>
          </Form.Group>
        </div>
      </div>

    );


  }


}

export default EditGenrePage;
