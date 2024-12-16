package System.OrdersApiPresenterLayer;

import OrdersApiModel.OrdersApiModel.*;

public interface IOrdersClient {

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId);

}