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
	public boolean UpdateData(ArrayList<ItemModel> partsList) {
		boolean response;
		response = itemService.UpdateData(partsList);
		return response;
	}

	/**
	 * 
	 * @param backup
	 */
	public boolean RecoverBackup(ArrayList<ItemModel> backup) {
		boolean response;
		response = itemService.RecoverBackup(backup);
		return response;
	}

	public ArrayList<ItemModel> ShowAll() {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = itemService.ShowAll();
		return itemList;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param partID
	 */
	public ArrayList<ItemModel> ShowPart(int partID) {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = itemService.ShowPart(partID);
		return itemList;
	}

	public ArrayList<ItemModel> ApplyFilter(int chosenFilter, int filterNumber) {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = itemService.ApplyFilter(chosenFilter, filterNumber);
		return itemList;
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