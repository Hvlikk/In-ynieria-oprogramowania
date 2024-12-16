package System.OrdersApiPresenterLayer.OrdersApiPresenter;

import OrdersApiPresenterLayer.*;
import OrdersApiModel.OrdersApiModel.*;

public class OrdersController implements IOrdersClient {

	private OrderRepairService orderRepairService;
	private OrderService orderService;

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		// TODO - implement OrdersController.CreateOrder
		throw new UnsupportedOperationException();
	}

}