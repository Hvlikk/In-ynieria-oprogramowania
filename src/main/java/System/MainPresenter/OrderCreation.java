package System.MainPresenter;

import OrdersApiModel.OrdersApiModel.*;

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