import React, {Component} from 'react';
import GenreTable from './GenreTable';
import {Form, Button} from 'react-bootstrap';
import Admin, {adminFetch} from "./Admin"

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
    adminFetch("http://localhost:8080/admin/fake.css").then(t => console.log(t)).catch(r => console.log(r))
    let url = 'http://localhost:8080/admin/addGenre?genre='+this.state.newGenre;
    console.log(url);
    e.preventDefault();
    //console.log(adminFetch);
    adminFetch(url)
        .then(th => console.log("then", th))
        .catch(ct => console.log(ct));
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
