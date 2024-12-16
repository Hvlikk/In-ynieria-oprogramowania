package System;

import System.OrdersApiModel.OrdersApiModel.IOrderModel;

public interface IOrderscClient {

	/**
	 * 
	 * @param order
	 */
	int CreateOrder(IOrderModel order);

}