package System.MainPresenter;

import OrdersApiModel.OrdersApiModel.*;

public class CreateSimpleOrderStrategy implements ICreateOrderStrategy {

	private CustomerService customerService;
	private OrderService orderService;

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		// TODO - implement CreateSimpleOrderStrategy.CreateOrder
		throw new UnsupportedOperationException();
	}

}