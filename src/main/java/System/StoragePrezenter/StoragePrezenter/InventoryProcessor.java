package System.StoragePrezenter.StoragePrezenter;

import System.StorageModel.StorageModel.*;
import System.IItemState;

import java.util.ArrayList;

public class InventoryProcessor {

	private IItemState itemState = ItemState.getInstance();

	/**
	 * 
	 * @param partsList
	 */
	public ItemModel[] UpdateData(ItemModel[] partsList) {
		// TODO - implement InventoryProcessor.UpdateData
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param backup
	 */
	public boolean RecoverBackup(ArrayList<ItemModel> backup) {

		return itemState.RecoverBackup(backup);
	}

	private void PrepareDataToUpdate() {
		// TODO - implement InventoryProcessor.PrepareDataToUpdate
		throw new UnsupportedOperationException();
	}

	private void PrepareBackup() {
		// TODO - implement InventoryProcessor.PrepareBackup
		throw new UnsupportedOperationException();
	}

}