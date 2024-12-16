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
	 * @param item
	 */
	bool SetPartID(ItemModel item);

	/**
	 * 
	 * @param item
	 */
	bool SetQuantity(ItemModel item);

}