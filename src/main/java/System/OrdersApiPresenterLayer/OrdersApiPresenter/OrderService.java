package System.OrdersApiPresenterLayer.OrdersApiPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;

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

	/**
	 * 
	 * @param id
	 */
	public IOrderModel GetOrder(Integer id) {
		// TODO - implement OrderService.GetOrder
		throw new UnsupportedOperationException();
	}

}