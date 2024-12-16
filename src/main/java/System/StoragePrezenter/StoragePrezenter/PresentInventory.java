package System.StoragePrezenter.StoragePrezenter;

import System.StorageModel.StorageModel.*;
import System.IItemState;

import java.util.ArrayList;

public class PresentInventory {

	private IItemState itemState = ItemState.getInstance();


	public ArrayList<ItemModel> ShowAll() {
		return itemState.DisplayAll();

		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param partID
	 */
	public ArrayList<ItemModel> ShowPart(int partID) {
		return itemState.SelectItemToDisplay(partID);
	}

	public ArrayList<ItemModel> ApplyFilter() {
		return itemState.FilterData();
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