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
    const picked = this.state.pickedModes.slice();
    picked.push(e.target.value);
    this.setState({pickedModes: picked});
    if(!this.props.editMode) {
      const onAdd = this.props.onAdd;
      onAdd(this.state.pickedModes);
    }
  }



  onAddMode() {
    const onAdd = this.props.onAdd;
    onAdd(this.state.pickedModes);
  }

  showMenu(e) {
    e.preventDefault();
    const showMenu = this.state.showMenu;
    this.setState({showMenu: !showMenu});
  }

  render() {
    const modes = this.state.modes;
    const useId = this.props.useId;
    const modeButtons = modes.map(m=> {
      return(
        <div>
          <input type = "checkbox" value = {useId ? m.id : m.mode} onChange={e => this.handleModeCheck(e)} />
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
        {this.props.editMode ?
          (<div>
            <button onClick = {e=>this.onAddMode(e)}>Add Playable Mode</button>
          </div>)
          :
          (null)
        }
      </div>


    );

  }


}

export default ModeDropdown;
