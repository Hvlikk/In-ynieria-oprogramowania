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
	public ItemModel[] UpdateData(ItemModel[] partsList) {
		// TODO - implement ItemService.UpdateData
		throw new UnsupportedOperationException();
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
	public ItemModel[] ShowPart(int partID) {
		// TODO - implement ItemService.ShowPart
		throw new UnsupportedOperationException();
	}

	public boolean ApplyFilter() {
		// TODO - implement ItemService.ApplyFilter
		throw new UnsupportedOperationException();
	}

}