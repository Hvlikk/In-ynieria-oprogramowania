package System.StoragePrezenter.StoragePrezenter;

import System.StorageModel.StorageModel.*;

import java.util.ArrayList;

public class ItemService {

	private InventoryProcessor invProcessor = new InventoryProcessor();
	private PresentInventory presentInventory = new PresentInventory();

	/**
	 * 
	 * @param partsList
	 */
	public boolean UpdateData(ArrayList<ItemModel> partsList) {
		return invProcessor.UpdateData(partsList);
	}

	/**
	 * 
	 * @param backup
	 */
	public boolean RecoverBackup(ArrayList<ItemModel> backup) {
		return invProcessor.RecoverBackup(backup);
	}

	public ArrayList<ItemModel> ShowAll() {
		return presentInventory.ShowAll();
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param partID
	 */
	public ArrayList<ItemModel> ShowPart(int partID) {
		return presentInventory.ShowPart(partID);
	}

	public ArrayList<ItemModel> ApplyFilter() {
		return presentInventory.ApplyFilter();
	}

}