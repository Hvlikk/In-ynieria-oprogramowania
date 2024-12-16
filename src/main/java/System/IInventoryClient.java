import StorageModel.StorageModel.*;

public interface IInventoryClient {

	/**
	 * 
	 * @param partsList
	 */
	ItemModel[] UpdateData(ItemModel[] partsList);

	/**
	 * 
	 * @param backup
	 */
	boolean RecoverBackup(ItemModel[] backup);

	ItemModel[] ShowAll();

	/**
	 * 
	 * @param partID
	 */
	ItemModel[] ShowPart(int partID);

	boolean ApplyFilter();

	void CreateReplenishmentOrder();

	void DeleteReplenishmentOrder();

}