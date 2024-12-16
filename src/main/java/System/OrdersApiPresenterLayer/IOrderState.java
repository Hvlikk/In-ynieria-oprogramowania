package System.OrdersApiPresenterLayer;

import System.OrdersApiModel.OrdersApiModel.IOrderModel;

import java.sql.Connection;

public interface IOrderState {

	boolean Disconnect();

	Connection Connect();

	/**
	 * 
	 * @param order
	 */
	boolean InsertOrder(IOrderModel order);

	/**
	 * 
	 * @param order
	 */
	int UpdateOrder(IOrderModel order);

	/**
	 * 
	 * @param orderId
	 */
	IOrderModel GetOrderById(int orderId);

	/**
	 * 
	 * @param orderId
	 */
	IOrderModel DeleteOrder(int orderId);

	/**
	 * 
	 * @param id
	 */
	IOrderModel GetOrder(Integer id);

    static IOrderState GetInstance() {
        return null;
    }

}