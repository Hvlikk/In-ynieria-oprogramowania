package System.MainPresenter;


import System.CustomerApi.CustomerApiModel.CustomerModel;
import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;

public class CreateSimpleOrderStrategy implements ICreateOrderStrategy {

	private CustomerService customerService = new CustomerService();
	private OrderService orderService = new OrderService();

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	@Override
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		CustomerModel customer = customerService.GetCustomer(clientId);
		return orderService.CreateOrder(device,order,workerId,customer.getId());
	}
}