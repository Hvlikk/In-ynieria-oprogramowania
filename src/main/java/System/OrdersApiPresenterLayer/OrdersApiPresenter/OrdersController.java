package System.OrdersApiPresenterLayer.OrdersApiPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.OrdersApiPresenterLayer.IOrdersClient;

public class OrdersController implements IOrdersClient {

	private OrderRepairService orderRepairService = new OrderRepairService();
	private OrderService orderService = new OrderService();

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		System.out.println("Success call to OrderApi\n");
		return orderService.CreateOrder(device,order,workerId,clientId);
	}

	/**
	 * 
	 * @param id
	 */
	public IOrderModel GetOrder(Integer id) {
		// TODO - implement OrdersController.GetOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public boolean ChangeOrder(IOrderModel order) {
		System.out.println("Success call to OrderApi\n");
		return orderService.UpdateOrder(order) > -1;
	}

}