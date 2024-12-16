package System.StorageModel.StorageModel;

public interface IItemModel {

	/**
	 * 
	 * @param item
	 */
	int GetPartID(ItemModel item);

	/**
	 * 
	 * @param item
	 */
	int GetQuantity(ItemModel item);

	/**
	 * 
	 * @param partID
	 */
	void SetPartID(int partID);

	/**
	 * 
	 * @param quantity
	 */
	void SetQuantity(int quantity);

}