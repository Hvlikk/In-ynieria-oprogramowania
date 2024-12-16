package System.MainPresenter;

import OrdersApiModel.OrdersApiModel.*;

public interface IWorkerFacade {

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId);

}