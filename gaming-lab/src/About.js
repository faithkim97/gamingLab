import React, {Component} from 'react';
import Fonts from './Fonts.css';
import {Image} from 'react-bootstrap';

class About extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return(
            <div style={{backgroundColor: "white", padding: "5%", overflow:"auto"}}>
                <h1 style={{fontFamily:  "Share Tech Mono, monospace"}}>Welcome to the Gaming Lab!</h1>
                <Image src="https://cdn-images-1.medium.com/max/1600/1*xuYna-3p8tl4VIalflussA.jpeg"
                style = {{width: "60%"}}/>
                <p style={{fontFamily:"Montserrat"}}>
                    Welcome to the Gaming Lab! The Gaming Lab is a space founded
                by Professor Jen Malkowski, a Film and Media Studies professor who is also interested in Game Studies here at Smith.
                    It is a space where students get to play video games, ranging from AAA games like <i>Uncharted: The Lost Legacy</i>
                    to Indie games like <i>Undertale</i>. We hope to create a safe space for students of all background to have a fun and immersive
                    experience.
                </p>

                <p style={{fontFamily: "Montserrat"}}>
                    The Gaming Lab is managed by student Lab Assistants, who will help you pick out a game (or you can use our search engine
                    to see what games are available), set up your game and make sure you don't run into any technical issues!

                </p>
            </div>


        );
    }
}

export default About;
