package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.OrdersApiPresenterLayer.IOrdersClient;
import System.OrdersApiPresenterLayer.OrdersApiPresenter.OrdersController;

public class OrderService {

	private IOrdersClient client = new OrdersController();

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		System.out.println("Success call to OrderApi");
		return client.CreateOrder(device,order,workerId,clientId);
	}

	/**
	 * 
	 * @param id
	 */
	public IOrderModel GetOrder(Integer id) {
		// TODO - implement OrderService.GetOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public boolean ChangeOrder(IOrderModel order) {
		System.out.println("Success call to OrderApi");
		return client.ChangeOrder(order);
	}

}