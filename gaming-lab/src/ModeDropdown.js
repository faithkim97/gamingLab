import React, { Component } from 'react';
//mapModeByModeGameIds
class ModeDropdown extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showMenu: false,
      modes: [],
      pickedModes: [],
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/game/modes').then(response => response.json())
    .then(data => this.setState({modes: data})).catch(console.log("could not retrieve modes"));
  }


  handleModeCheck(e) {
    e.preventDefault();
    const picked = this.state.pickedModes.slice();
    picked.push(e.target.value);
    this.setState({pickedModes: picked});
  }

  handleAddMode(e, game) {
    fetch('http://localhost:8080/admin/mapModeByModeGameIds?gameId='+game.id+"&modeIds="+this.state.pickedModes);
  }

  showMenu(e) {
    e.preventDefault();
    const showMenu = this.state.showMenu;
    this.setState({showMenu: !showMenu});
  }

  render() {
    const modes = this.state.modes;
    const modeButtons = modes.map(m=> {
      return(
        <div>
          <input type = "checkbox" value = {m.id} onChange={e => this.handleModeCheck(e)} checked = {false} />
          {m.mode}
        </div>
      );

    });

    return(
      <div>
        <div>
          <button onClick={e => {this.showMenu(e)}}>Playable Modes</button>
        </div>
        {
          this.state.showMenu ?
          (
            <div className="menu">
              {modeButtons}
            </div>

          ) :
          (
            null
          )

        }
        <div>
          <button onClick = {e => this.handleAddMode(e, this.props.value)}>Add Playable Mode</button>
        </div>
      </div>


    );

  }


}

export default ModeDropdown;
