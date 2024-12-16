package System;
import System.StorageModel.StorageModel.*;

import java.util.ArrayList;

public interface IItemState {

	/**
	 * 
	 * @param itemsToUpdate
	 */
	boolean UpdateItems(ArrayList<ItemModel> itemsToUpdate);

	ArrayList<ItemModel> DisplayAll();

	/**
	 * 
	 * @param backup
	 */
	boolean RecoverBackup(ArrayList<ItemModel> backup);

	ArrayList<ItemModel> FilterData();

	/**
	 * 
	 * @param partID
	 */
	ArrayList<ItemModel> SelectItemToDisplay(int partID);

}