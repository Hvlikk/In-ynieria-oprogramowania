package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;

public class OrderCreation {

	CreateOrderContext orderContext = new CreateOrderContext();

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		return orderContext.CreateOrder(device,order,workerId,clientId);
	}

	/**
	 * 
	 * @param strategy
	 */
	public void SetStrategy(ICreateOrderStrategy strategy) {
		orderContext.SetStrategy(strategy);
	}

}