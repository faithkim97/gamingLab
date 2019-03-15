import React, { Component } from 'react';
import GameTable from './GameTable';
/*
Things to create:

a Submit form that contains:
-A search bar (title, desc, genre)
-A radio button option for Console
-radio button option for mode
*/
class SearchEngine extends Component {
  constructor(props) {
    super(props);
    this.state = {
      games: [{
        title: "tomb raider",
        description: "survive the horrors",
        genres: "survival, horror",
        console: "ps4",
        mode: "single player"
      },
    ],

  };

  this.handleSubmit = this.handleSubmit.bind(this);
}//endcon

  handleSubmit() {
    console.log("submitted");
  }

/*
handleSubmit(e) {
		e.preventDefault();
		const currList = this.state.grocList.slice();
		const {newItem, newPrice, newAmount} = this.state;
		const newCost = sum(this.state.totalCost, newPrice);

		const hasItemIndex = indexItem(newItem, currList);
		if (hasItemIndex > -1) {
			currList[hasItemIndex].amount += 1;
		} else {
			currList.push({
				name: newItem,
				price: newPrice,
				amount: newAmount + 1,
			});
		}


		this.setState({
			grocList: currList,
			totalCost: newCost,
		});

	}
*/
/* <form onSubmit={this.handleSubmit}>
						Name of item: <input type='text' value = {this.state.newItem} onChange={this.handleNewItem}  />
						Price: <input type='number' value = {this.state.newPrice} onChange={this.handleNewPrice}  />
						<input type = "submit" value="Submit"/>
					</form> */

  render() {
    return (
        // <form onSubmit={handleSubmit}>
        <div>
        <form onSubmit = {handleSubmit}>
          <input type = 'text' />
          <input type = "submit" value = "Search" />
        </form>
        <div>
          <GameTable value={this.state.games} />
        </div>
        </div>



  );
}//endrender
}

export default SearchEngine;
