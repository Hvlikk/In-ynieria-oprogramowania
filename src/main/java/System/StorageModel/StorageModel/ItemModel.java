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
		return this.partID;
	}

	/**
	 * 
	 * @param item
	 */
	public int GetQuantity(ItemModel item) {
		return this.quantity;
	}

	/**
	 * 
	 * @param partID
	 */
	public void SetPartID(int partID) {
		this.partID = partID;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void SetQuantity(int quantity) {
		this.quantity = quantity;
	}

}