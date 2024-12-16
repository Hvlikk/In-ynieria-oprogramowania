package System.MainPresenter;

import OrdersApiModel.OrdersApiModel.*;

public class CreateOrderContext {

	private ICreateOrderStrategy strategy;

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		// TODO - implement CreateOrderContext.CreateOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param strategy
	 */
	public void SetStrategy(ICreateOrderStrategy strategy) {
		// TODO - implement CreateOrderContext.SetStrategy
		throw new UnsupportedOperationException();
	}

}