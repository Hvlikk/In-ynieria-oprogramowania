package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public class OrderFacade implements IOrderFacade {

	private OrderCreation OrderCreation;
	private WorkerService workerService;
	private OrderService orderService;

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		// TODO - implement OrderFacade.CreateOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param worker
	 * @param order
	 */
	@Override
	public boolean ChangeWorkerForOrder(IWorkerModel worker, IOrderModel order) {
		// TODO - implement OrderFacade.ChangeWorkerForOrder
		throw new UnsupportedOperationException();
	}

}