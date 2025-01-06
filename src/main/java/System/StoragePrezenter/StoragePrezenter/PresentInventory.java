package System.StoragePrezenter.StoragePrezenter;

import System.StorageModel.StorageModel.*;
import System.IItemState;

import java.util.ArrayList;

public class PresentInventory {

	private IItemState itemState = ItemState.getInstance();


	public ArrayList<ItemModel> ShowAll() {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = itemState.DisplayAll();
		return itemList;

		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param partID
	 */
	public ArrayList<ItemModel> ShowPart(int partID) {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = itemState.SelectItemToDisplay(partID);
		return itemList;
	}

	public ArrayList<ItemModel> ApplyFilter(int chosenFilter, int filterNumber) {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = itemState.FilterData(chosenFilter, filterNumber);
		return itemList;
	}

	private void PrepareInventoryStateToDisplay() {
		// TODO - implement PresentInventory.PrepareInventoryStateToDisplay
		throw new UnsupportedOperationException();
	}

	private void PreparePartStateToDisplay() {
		// TODO - implement PresentInventory.PreparePartStateToDisplay
		throw new UnsupportedOperationException();
	}

	private void PrepareFilterToApply() {
		// TODO - implement PresentInventory.PrepareFilterToApply
		throw new UnsupportedOperationException();
	}

}