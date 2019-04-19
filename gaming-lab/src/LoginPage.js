import React, {Component} from 'react';
import Admin, {adminFetch, setPassword} from './Admin';
import {InputGroup, Button, Form} from 'react-bootstrap';

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state ={
          password: '',
        };
    }

    changePassword(e) {
        this.setState({password: e.target.value});
    }

    handleSubmit(e) {
        e.preventDefault();
        setPassword(this.state.password);
    }


    render() {
       return(
           <div style={{width: "50%"}}>
           <h1>Log In</h1>
           <Form onSubmit={e=>this.handleSubmit(e)}>
               <Form.Label>Password </Form.Label>
               <Form.Control type="password" value={this.state.password} onChange={e=>this.changePassword(e)}/>
               <input type="submit" value="Login"/>
           </Form>
           </div>
       );

    }


}

export default LoginPage;