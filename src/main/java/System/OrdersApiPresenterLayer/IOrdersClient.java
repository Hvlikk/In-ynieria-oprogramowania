package System.OrdersApiPresenterLayer;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;

public interface IOrdersClient {

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId);

	/**
	 * 
	 * @param id
	 */
	IOrderModel GetOrder(Integer id);

	/**
	 * 
	 * @param order
	 */
	boolean ChangeOrder(IOrderModel order);

}