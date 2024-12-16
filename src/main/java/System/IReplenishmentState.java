package System;

public interface IReplenishmentState {

	/**
	 * 
	 * @param order
	 */
	boolean InsertOrder(IReplenishment order);

	/**
	 * 
	 * @param orderID
	 */
	boolean DeleteOrder(int orderID);

}