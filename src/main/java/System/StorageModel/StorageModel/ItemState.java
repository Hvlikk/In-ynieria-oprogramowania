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
	public ItemModel[] SelectItemToDisplay(int partID) {
		// TODO - implement ItemState.SelectItemToDisplay
		throw new UnsupportedOperationException();
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
	public ItemModel[] UpdateItems(ItemModel[] itemsToUpdate) {
		// TODO - implement ItemState.UpdateItems
		throw new UnsupportedOperationException();
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
	public boolean CreateItem(int partID, int quantity) {
		// TODO - implement ItemState.CreateItem
		throw new UnsupportedOperationException();
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