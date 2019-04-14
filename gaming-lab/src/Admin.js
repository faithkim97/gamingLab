import React, { Component } from 'react';
import {Nav, Dropdown, DropdownButton} from "react-bootstrap";

class Admin extends Component {
  constructor(props) {
    super(props);
  }

  //TODO we don't have admin fetch anymore in backend
  // componentDidMount() {
  //   fetch("http://localhost:8080/admin/");
  // }

  render() {
      return(
          <Nav fill variant="tabs" defaultActivekey="/admin">
              <Nav.Item>
                  <Nav.Link href="/home">Home</Nav.Link>
              </Nav.Item>
              <Nav.Item>
                  <Nav.Link href="/admin/search">Search Games to Edit</Nav.Link>
              </Nav.Item>
              <Nav.Item>
                  <Nav.Link href="/admin/addgame">Add New Game</Nav.Link>
              </Nav.Item>
              <Nav.Item>
                  <DropdownButton title="Edit Game Fields">
                      <Dropdown.Item href="/admin/editgenre">Edit Genre</Dropdown.Item>
                      <Dropdown.Item href="/admin/editconsole">Edit Console</Dropdown.Item>
                      <Dropdown.Item href="/admin/editmode">Edit Playable Mode</Dropdown.Item>
                  </DropdownButton>
              </Nav.Item>


          </Nav>

      );

  }

}
export default Admin;
