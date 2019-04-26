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
                <h1 style={{textAlign:"left", fontFamily:  "Share Tech Mono, monospace"}}>Welcome to the Gaming Lab!</h1>
                <br></br>
               <center> <Image src="https://cdn-images-1.medium.com/max/1600/1*xuYna-3p8tl4VIalflussA.jpeg"
                               style = {{width: "60%"}}/></center>

                <p></p>
                <p style={{fontFamily:"Montserrat"}}>
                    Welcome to the Gaming Lab! The Gaming Lab is a space founded
                    by <a href="https://www.smith.edu/academics/faculty/jennifer-malkowski">Professor Jen Malkowski</a>, a Film and Media Studies professor who is also interested in Game Studies here at Smith.
                    It is a space where students get to play video games, ranging from AAA games like <i>Uncharted: The Lost Legacy</i> to Indie games like <i>Undertale</i>. We hope to create a safe space for students of all background to have a fun and immersive
                    experience.
                </p>

                <p style={{fontFamily: "Montserrat"}}>
                    The Gaming Lab is managed by student Lab Assistants, who will help you pick out a game (or you can use our search engine
                    to see what games are available), set up your game, and make sure you don't run into any technical issues! If you'd like to know
                    more about our open hours, then please check out our <a href="https://www.facebook.com/gaminglabatsmithcollege/?modal=admin_todo_tour">Facebook Page!</a> They vary semester to semester.
                </p>

                <center><a href = "https://www.smith.edu/about-smith/news/digital-storytelling?fbclid=IwAR2HaFyUzPJ5MuxiUMksIuOUCU5rfB6k3zL8ii2PTWrxqz88mlI5MQM89Is">
                    <Image src ="https://www.smith.edu/sites/default/files/styles/news_header/public/media/-news/Gaming2.jpg?itok=fppJ7Kri"/></a>
                    <p></p>
                    <p style = {{fontFamily: "Montserrat"}}> Also if you're interested, check out the Grecourt Gate's article on the Gaming Lab, 'A Space for Digital Storytelling.'</p></center>
            </div>


        );
    }
}

export default About;
