package System.StorageModel.StorageModel;

public interface IItemModel {


	int GetPartID();


	int GetQuantity();

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