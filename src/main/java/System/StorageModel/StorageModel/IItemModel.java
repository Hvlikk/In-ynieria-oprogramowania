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
	boolean SetPartID(ItemModel item);

	/**
	 * 
	 * @param item
	 */
	boolean SetQuantity(ItemModel item);

}