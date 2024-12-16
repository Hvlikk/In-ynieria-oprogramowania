package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;

public class OrderCreation {

	CreateOrderContext orderContext;

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		// TODO - implement OrderCreation.CreateOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param strategy
	 */
	public void SetStrategy(ICreateOrderStrategy strategy) {
		// TODO - implement OrderCreation.SetStrategy
		throw new UnsupportedOperationException();
	}

}