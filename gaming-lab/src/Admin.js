import React, { Component } from 'react';
import {Nav, Dropdown, DropdownButton} from "react-bootstrap";

function getPassword() {
  return window.localStorage.getItem("admin-password");
}

export function adminFetch(url) {
  let password = getPassword();
  console.log(url, password);

  if (!password) {
    // TODO redirect to login page
    console.log("TO REDIRECT")
    return null;
  }
  let headers = new Headers();
  headers.set('Authorization', 'Basic ' + btoa("admin:" + password))
  return fetch(url, {
    headers: headers,
  });
}

function setPassword(password) {
  let headers = new Headers();
  headers.set('Authorization', 'Basic ' + btoa("admin:" + password))
  fetch("http://localhost:8080/admin/fake.css", {
    headers: headers,
  }).then((data) => {
    window.localStorage.setItem("admin-password", password);
  }).error((data) => {
    // TODO redirect to bad password page
  });
}

class Admin extends Component {
  constructor(props) {
    super(props);
  }

  //TODO we don't have admin fetch anymore in backend
  componentDidMount() {
    adminFetch("http://localhost:8080/admin/fake.css");
  }

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
