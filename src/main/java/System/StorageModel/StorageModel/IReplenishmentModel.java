package System.StorageModel.StorageModel;

public interface IReplenishmentModel {

	/**
	 * 
	 * @param order
	 */
	boolean InsertOrder(ReplenishmentModel order);

	/**
	 * 
	 * @param orderID
	 */
	boolean DeleteOrder(int orderID);

}