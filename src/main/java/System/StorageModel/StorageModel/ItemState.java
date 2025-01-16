package System.StorageModel.StorageModel;
import System.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemState implements IItemState {

	private ArrayList<ItemModel> itemList = new ArrayList<>();
	private static ItemState instance;
	private int uniqueID = 0;

	/**
	 * 
	 * @param partID
	 */
	public ArrayList<ItemModel> SelectItemToDisplay(int partID) {
		int itemListID;
		ArrayList<ItemModel> itemFound = new ArrayList<>();
		ItemModel itemToDisplay;

		for(int i = 0; i < itemList.size(); i++){
			itemToDisplay = itemList.get(i);
			itemListID = itemToDisplay.GetPartID();

			if (itemListID == partID){
				itemFound.add(itemToDisplay);
			}
		}
		return itemFound;
	}

	public static ItemState getInstance() {
		if (instance == null) {
			instance = new ItemState();
		}
		return instance;
	}


	/**
	 * 
	 * @param itemsToUpdate
	 */
	public boolean UpdateItems(ArrayList<ItemModel> itemsToUpdate) {
		boolean partListFound = false;
		int updateID, dbID, insertID, insertQuant, quantToSet, quantInDatabase;
		ItemModel itemToUpdate, dbItem, itemToInsert;

		if (itemsToUpdate == null) {
			throw new NullPointerException("itemsToUpdate cannot be null");
		}

		for (ItemModel item : itemsToUpdate) {
			if (item.GetPartID() < 0 || item.GetQuantity() < 0) {
				throw new IllegalArgumentException("partID and quantity cannot be negative");
			}
		}
		
		try {
			for (int i = 0; i < itemsToUpdate.size(); i++) {
				for (int j = 0; j < itemList.size(); j++) {
					itemToUpdate = itemsToUpdate.get(i);
					updateID = itemToUpdate.GetPartID();
					dbItem = itemList.get(j);
					dbID = dbItem.GetPartID();

					if (updateID == dbID){
						quantToSet = itemToUpdate.GetQuantity();
						dbItem.SetQuantity(quantToSet);
						partListFound = true;
					}

					if (partListFound)
						break;
				}

				if (!partListFound){
					itemToInsert = itemsToUpdate.get(i);
					itemList.add(itemToInsert);
				}

				partListFound = false;
			}
		} catch (Exception ex) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param backup
	 */
	public boolean RecoverBackup(ArrayList<ItemModel> backup) {
		if (backup == null) {
			throw new NullPointerException("Backup cannot be null");
		}
		this.itemList = backup;
		return true;
	}

	/**
	 * 
	 * @param partID
	 * @param quantity
	 */
	public ItemModel CreateItem(int partID, int quantity) {
		if (partID < 0 || quantity < 0) {
			throw new IllegalArgumentException("partID and quantity cannot be negative");
		}
		return new ItemModel(partID, quantity);
	}

	public ArrayList<ItemModel> FilterData(int chosenFilter, int filterNumber) {

		if (chosenFilter < 1 || chosenFilter > 4) {
			throw new IllegalArgumentException("Invalid filter type");
		}

		ArrayList<ItemModel> filteredItems = new ArrayList<>();
		int searchedItemID, searchedItemQuant;
		ItemModel searchedItem;

		switch (chosenFilter){
			case 1: {
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemID = searchedItem.GetPartID();

					if (searchedItemID > filterNumber)
						filteredItems.add(searchedItem);
				}
				break;
			}
			case 2:{
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemID = searchedItem.GetPartID();

					if (searchedItemID < filterNumber)
						filteredItems.add(searchedItem);
				}
				break;
			}

			case 3: {
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemQuant = searchedItem.GetQuantity();

					if (searchedItemQuant > filterNumber)
						filteredItems.add(searchedItem);
				}
				break;
			}

			case 4: {
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemQuant = searchedItem.GetQuantity();

					if (searchedItemQuant < filterNumber)
						filteredItems.add(searchedItem);
				}
			}
			default:
				break;
		}

		return filteredItems;

	}

	public ArrayList<ItemModel> DisplayAll() {
//		itemList.add(new ItemModel(1,1));
//		itemList.add(new ItemModel(2,1));
//		itemList.add(new ItemModel(3,1));
//		itemList.add(new ItemModel(4,1));
		return itemList;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void SaveData(ItemModel item) {
		// TODO - implement ItemState.SaveData
		throw new UnsupportedOperationException();
	}

	public boolean SpecifyFilter() {
		// TODO - implement ItemState.SpecifyFilter
		throw new UnsupportedOperationException();
	}

	public boolean AppendData() {
		// TODO - implement ItemState.AppendData
		throw new UnsupportedOperationException();
	}

	public boolean ClearResponseData() {
		// TODO - implement ItemState.ClearResponseData
		throw new UnsupportedOperationException();
	}

}