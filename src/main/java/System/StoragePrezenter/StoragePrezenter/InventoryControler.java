package System.StoragePrezenter.StoragePrezenter;
import System.IInventoryClient;
import System.StorageModel.StorageModel.*;

import java.util.ArrayList;

public class InventoryControler implements IInventoryClient {

	private ItemService itemService = new ItemService();

	/**
	 * 
	 * @param partsList
	 */
	public ItemModel[] UpdateData(ItemModel[] partsList) {
		// TODO - implement InventoryControler.UpdateData
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param backup
	 */
	public boolean RecoverBackup(ArrayList<ItemModel> backup) {
		return itemService.RecoverBackup(backup);
	}

	public ArrayList<ItemModel> ShowAll() {
		return itemService.ShowAll();
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param partID
	 */
	public ItemModel[] ShowPart(int partID) {
		// TODO - implement InventoryControler.ShowPart
		throw new UnsupportedOperationException();
	}

	public boolean ApplyFilter() {
		// TODO - implement InventoryControler.ApplyFilter
		throw new UnsupportedOperationException();
	}

	public void CreateReplenishmentOrder() {
		// TODO - implement InventoryControler.CreateReplenishmentOrder
		throw new UnsupportedOperationException();
	}

	public void DeleteReplenishmentOrder() {
		// TODO - implement InventoryControler.DeleteReplenishmentOrder
		throw new UnsupportedOperationException();
	}

}