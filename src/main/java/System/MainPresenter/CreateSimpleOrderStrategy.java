package System.MainPresenter;


import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;

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
	@Override
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		return null;
	}
}