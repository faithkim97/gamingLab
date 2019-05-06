import React, { Component } from 'react';
import {Button} from 'react-bootstrap';

function removeFromPickedModes(itemToRemove, modes) {
    for (let i = 0; i < modes.length; i++) {
      if (itemToRemove.id == modes[i].id) {
        modes.splice(i,1);
      }
    }

    return modes;
}

class ModeDropdown extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showMenu: false,
      modes: [],
      pickedModes: [],
      checkedMap: {},
    };
  }

  componentDidMount() {
    fetch('/game/modes').then(response => response.json())
    .then(data => this.setState({modes: data}, () => {
      const checkedMap = {};
      const modes = this.state.modes;
      modes.forEach(m =>{
        checkedMap[m.id] = false;
      });
      this.setState({checkedMap: checkedMap});
    }

    )).catch(console.log("could not retrieve modes"));
  }


  handleModeCheck(e, mode) {
    const checkedMap = this.state.checkedMap;
    checkedMap[mode.id] = !e.target.checked == false ? true : false;
    this.setState({checkedMap: checkedMap});
    if (!e.target.checked) {
      const pickedModes = removeFromPickedModes(mode, this.state.pickedModes);
      this.setState({pickedModes: pickedModes});
    } else {
      const picked = this.state.pickedModes.slice();
      picked.push(mode);
      this.setState({pickedModes: picked}, () => {
        if(!this.props.editMode) {
          const onAdd = this.props.onAdd;
          onAdd(this.state.pickedModes);
        }
      });
    }//endelse
  }



  onAddMode() {
    const onAdd = this.props.onAdd;
    if (this.props.useId) {
      const modeIds = [];
      this.state.pickedModes.forEach(m => {
        modeIds.push(m.id)
      });
      onAdd(modeIds);
    } else {
      onAdd(this.state.pickedModes);

    }
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
          <input type = "checkbox" checked={this.state.checkedMap[m.id]}
          value = {useId ? m.id : m} onChange={e => this.handleModeCheck(e, m)} />
          {m.mode}
        </div>
      );

    });

    return(
      <div>
        <div className="menu">
          {modeButtons}
        </div>

        {this.props.editMode ?
          (<div>
            <Button variant="warning" onClick = {e=>this.onAddMode(e)}>Add Playable Mode(s)</Button>
          </div>)
          :
          (null)
        }
      </div>


    );

  }


}

export default ModeDropdown;
