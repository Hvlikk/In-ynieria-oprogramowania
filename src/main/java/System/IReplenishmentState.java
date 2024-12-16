public interface IReplenishmentState {

	/**
	 * 
	 * @param order
	 */
	boolean InsertOrder(IIReplenishmentModel order);

	/**
	 * 
	 * @param orderID
	 */
	boolean DeleteOrder(int orderID);

}