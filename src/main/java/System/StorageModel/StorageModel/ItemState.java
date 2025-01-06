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
			itemListID = itemToDisplay.GetPartID(itemToDisplay);

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

		try {
			for (int i = 0; i < itemsToUpdate.size(); i++) {
				for (int j = 0; j < itemList.size(); j++) {
					itemToUpdate = itemsToUpdate.get(i);
					updateID = itemToUpdate.GetPartID(itemToUpdate);
					dbItem = itemList.get(j);
					dbID = dbItem.GetPartID(dbItem);

					if (updateID == dbID){
						quantToSet = itemToUpdate.GetQuantity(itemToUpdate);
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
		boolean response = false;
		try {
			itemList = backup;
			response = true;
		} catch (Exception ex){
			response = false;
			return response;
		}
		return response;
	}

	/**
	 * 
	 * @param partID
	 * @param quantity
	 */
	public ItemModel CreateItem(int partID, int quantity) {
		return new ItemModel(partID, quantity);
	}

	public ArrayList<ItemModel> FilterData() {

		ArrayList<ItemModel> filteredItems = new ArrayList<>();
		int chosenFilter, filterNumber, searchedItemID, searchedItemQuant;
		ItemModel searchedItem;

		System.out.printf("partID > partIDFilter         | 1\n");
		System.out.printf("partID < partIDFilter         | 2\n");
		System.out.printf("quantity > quantityFilter     | 3\n");
		System.out.printf("quantity < quantityFilter     | 4\n");
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Wybierz filtr: \n");
		chosenFilter = scanner.nextInt();
		System.out.printf("Podaj wartosc filtra: \n");
		filterNumber = scanner.nextInt();

		switch (chosenFilter){
			case 1: {
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemID = searchedItem.GetPartID(searchedItem);

					if (searchedItemID > filterNumber)
						filteredItems.add(searchedItem);
				}
				break;
			}
			case 2:{
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemID = searchedItem.GetPartID(searchedItem);

					if (searchedItemID < filterNumber)
						filteredItems.add(searchedItem);
				}
				break;
			}

			case 3: {
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemQuant = searchedItem.GetQuantity(searchedItem);

					if (searchedItemQuant > filterNumber)
						filteredItems.add(searchedItem);
				}
				break;
			}

			case 4: {
				for (int i = 0; i < itemList.size(); i++){
					searchedItem = itemList.get(i);
					searchedItemQuant = searchedItem.GetQuantity(searchedItem);

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