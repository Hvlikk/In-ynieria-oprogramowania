package System.StorageModel.StorageModel;

public class ItemModel implements IItemModel {

	private int partID;
	private int quantity;

	public ItemModel(int partID, int quantity){
		this.partID = partID;
		this.quantity = quantity;
	}

	/**
	 * 
	 * @param item
	 */
	public int GetPartID(ItemModel item) {
		return item.partID;
	}

	/**
	 * 
	 * @param item
	 */
	public int GetQuantity(ItemModel item) {
		return item.quantity;
	}

	/**
	 * 
	 * @param item
	 */
	public boolean SetPartID(ItemModel item) {
		// TODO - implement ItemModel.SetPartID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public boolean SetQuantity(ItemModel item) {
		// TODO - implement ItemModel.SetQuantity
		throw new UnsupportedOperationException();
	}

}