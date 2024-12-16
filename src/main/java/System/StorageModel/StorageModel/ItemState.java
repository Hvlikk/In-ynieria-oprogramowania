package System.StorageModel.StorageModel;
import System.*;
import java.util.ArrayList;

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
		for(int i = 0; i < itemList.size(); i++){
			itemListID = itemList.get(i).GetPartID(itemList.get(i));

			if (itemListID == partID){
				itemFound.add(itemList.get(i));
			} else
				continue;
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
		boolean updated = true;
		boolean partListFound = false;
		int updateID, dbID, insertID, insertQuant;
		try {
			for (int i = 0; i < itemsToUpdate.size(); i++) {
				for (int j = 0; j < itemList.size(); j++) {
					updateID = itemsToUpdate.get(i).GetPartID(itemsToUpdate.get(i));
					dbID = itemList.get(j).GetPartID(itemList.get(j));

					if (updateID == dbID){
						itemList.get(j).SetQuantity(itemsToUpdate.get(i).GetQuantity(itemList.get(i)));
						partListFound = true;
					}

					if (partListFound)
						break;
				}

				if (partListFound == false){
					insertID = itemsToUpdate.get(i).GetPartID(itemsToUpdate.get(i));
					insertQuant = itemsToUpdate.get(i).GetQuantity(itemsToUpdate.get(i));
					itemList.add(CreateItem(insertID, insertQuant));
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
		try {
			itemList = backup;
			for (int i = 0; i < itemList.size(); i++)
			{
				System.out.println("ID" + itemList.get(i).GetPartID(itemList.get(i)) + "Quant" + itemList.get(i).GetQuantity(itemList.get(i)));
			}
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * 
	 * @param partID
	 * @param quantity
	 */
	public ItemModel CreateItem(int partID, int quantity) {
		return new ItemModel(partID, quantity);
	}

	public ItemModel[] FilterData() {
		// TODO - implement ItemState.FilterData
		throw new UnsupportedOperationException();
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