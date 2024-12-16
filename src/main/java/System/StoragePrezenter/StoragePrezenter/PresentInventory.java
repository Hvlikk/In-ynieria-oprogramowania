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
	public ItemModel[] ShowPart(int partID) {
		// TODO - implement PresentInventory.ShowPart
		throw new UnsupportedOperationException();
	}

	public boolean ApplyFilter() {
		// TODO - implement PresentInventory.ApplyFilter
		throw new UnsupportedOperationException();
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