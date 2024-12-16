package System.OrdersApiPresenterLayer.OrdersApiPresenter;

import OrdersApiModel.OrdersApiModel.*;

public class OrderService {

	private IOrderCreation orderCreationChain;

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		// TODO - implement OrderService.CreateOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public int UpdateOrder(IOrderModel order) {
		// TODO - implement OrderService.UpdateOrder
		throw new UnsupportedOperationException();
	}

}