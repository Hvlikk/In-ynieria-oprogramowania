package System;

import System.StorageModel.StorageModel.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IInventoryClient {

	/**
	 * 
	 * @param partsList
	 */
	boolean UpdateData(ArrayList<ItemModel> partsList);

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
	ArrayList<ItemModel> ShowPart(int partID);

	boolean ApplyFilter();

	void CreateReplenishmentOrder();

	void DeleteReplenishmentOrder();

}