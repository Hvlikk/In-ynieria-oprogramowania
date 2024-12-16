package System;

import System.StorageModel.StorageModel.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
	boolean RecoverBackup(ArrayList<ItemModel> backup);

	ArrayList<ItemModel> ShowAll();

	/**
	 * 
	 * @param partID
	 */
	ItemModel[] ShowPart(int partID);

	boolean ApplyFilter();

	void CreateReplenishmentOrder();

	void DeleteReplenishmentOrder();

}