package System.StoragePrezenter.StoragePrezenter;

import StorageModel.StorageModel.*;

public class InventoryControler implements IInventoryClient {

	private ItemService itemService;

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
	public boolean RecoverBackup(ItemModel[] backup) {
		// TODO - implement InventoryControler.RecoverBackup
		throw new UnsupportedOperationException();
	}

	public ItemModel[] ShowAll() {
		// TODO - implement InventoryControler.ShowAll
		throw new UnsupportedOperationException();
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