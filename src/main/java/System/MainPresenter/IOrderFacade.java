package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public interface IOrderFacade {

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId);

	/**
	 * 
	 * @param worker
	 * @param order
	 */
	boolean ChangeWorkerForOrder(IWorkerModel worker, IOrderModel order);

}