package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;

public interface ICreateOrderStrategy {

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId);

}