package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.OrdersApiPresenterLayer.IOrdersClient;

public class OrderService {

	private IOrdersClient client;

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
		// TODO - implement OrderService.ChangeOrder
		throw new UnsupportedOperationException();
	}

}