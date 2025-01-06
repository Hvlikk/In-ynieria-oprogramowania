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
		boolean response;
		response = invProcessor.UpdateData(partsList);
		return response;
	}

	/**
	 * 
	 * @param backup
	 */
	public boolean RecoverBackup(ArrayList<ItemModel> backup) {
		boolean response;
		response = invProcessor.RecoverBackup(backup);
		return response;
	}

	public ArrayList<ItemModel> ShowAll() {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = presentInventory.ShowAll();
		return itemList;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param partID
	 */
	public ArrayList<ItemModel> ShowPart(int partID) {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = presentInventory.ShowPart(partID);
		return itemList;
	}

	public ArrayList<ItemModel> ApplyFilter() {
		ArrayList<ItemModel> itemList = new ArrayList<>();
		itemList = presentInventory.ApplyFilter();
		return itemList;
	}

}