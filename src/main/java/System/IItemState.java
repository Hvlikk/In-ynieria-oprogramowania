import StorageModel.StorageModel.*;

public interface IItemState {

	/**
	 * 
	 * @param itemsToUpdate
	 */
	ItemModel[] UpdateItems(ItemModel[] itemsToUpdate);

	ItemModel[] DisplayAll();

	/**
	 * 
	 * @param backup
	 */
	boolean RecoverBackup(ItemModel[] backup);

	void operation();

	void operation2();

	ItemModel[] FilterData();

	/**
	 * 
	 * @param partID
	 */
	ItemModel[] SelectItemToDisplay(int partID);

}