import React, { Component } from 'react';
import {Nav, Dropdown, DropdownButton} from "react-bootstrap";
import LoginPage from './LoginPage';

export function getPassword() {
  return window.localStorage.getItem("admin-password");
}

export function adminFetch(url) {
  let password = getPassword();

  if (!password) {
      window.location = '/login';
    return null;
  }
  let headers = new Headers();
  headers.set('Authorization', 'Basic ' + btoa("admin:" + password));
  return fetch(url, {
    headers: headers,
  });
}

export function adminFetchPost(url, body) {
    //the body is getting passed in fine, and should work
    let password = getPassword();
    if (!password) {
        window.location = '/login';
        return null;
    }
    let headers = new Headers();
    headers.set('Authorization', 'Basic' + btoa("admin:" +password));
    headers.set("Accept", "application/json");
    headers.set("Content-Type", "application/json");
    console.log(body);
    return fetch(url, {
        method: "POST",
        headers: {
            "Accept":"application/json",
            "Content-Type": "application/json",
            "Authorization":'Basic ' + btoa("admin:" +password),
        },
        body: JSON.stringify(body),
    });
}

export function setPassword(password) {
  let headers = new Headers();
  headers.set('Authorization', 'Basic ' + btoa("admin:" + password))
  fetch("/admin/fake", {
    headers: headers,
  }).then((data) => {
      if (data.status == 401) {
          window.location ='/home';
      } else {
          window.localStorage.setItem("admin-password", password);
          window.location = '/admin';
      }
  });
}



class Admin extends Component {

  constructor(props) {
    super(props);
    this.state = {
        active: '',
    }
  }

  //TODO we don't have admin fetch anymore in backend
  componentDidMount() {
    adminFetch("/admin/fake");
  }

  render() {
      return(
          <div>
          <Nav fill variant="tabs" defaultActivekey={this.state.active} style={{fontFamily:  "Share Tech Mono, monospace"}}>
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
          </div>
      );

  }

}
export default Admin;
