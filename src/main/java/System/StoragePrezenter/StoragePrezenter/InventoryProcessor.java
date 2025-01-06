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
	public boolean UpdateData(ArrayList<ItemModel> partsList) {
		boolean response;
		response = itemState.UpdateItems(partsList);
		return response;
	}

	/**
	 * 
	 * @param backup
	 */
	public boolean RecoverBackup(ArrayList<ItemModel> backup) {
		boolean response;
		response = itemState.RecoverBackup(backup);
		return response;
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