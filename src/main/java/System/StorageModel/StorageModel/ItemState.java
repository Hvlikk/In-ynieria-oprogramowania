package System.StorageModel.StorageModel;

public class ItemState implements IItemState {

	private ArrayList<ItemModel> itemLIst;
	private static ItemState instance;

	/**
	 * 
	 * @param partID
	 */
	public ItemModel[] SelectItemToDisplay(int partID) {
		// TODO - implement ItemState.SelectItemToDisplay
		throw new UnsupportedOperationException();
	}

	public ItemState getInstance() {
		return this.instance;
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
	public boolean RecoverBackup(ItemModel[] backup) {
		// TODO - implement ItemState.RecoverBackup
		throw new UnsupportedOperationException();
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

	public ItemModel[] DisplayAll() {
		// TODO - implement ItemState.DisplayAll
		throw new UnsupportedOperationException();
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