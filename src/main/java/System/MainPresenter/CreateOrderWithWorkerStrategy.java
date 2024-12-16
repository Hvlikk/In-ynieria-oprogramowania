package System.MainPresenter;

import WorkerApiModelLayer.WorkersApiModel.*;
import OrdersApiModel.OrdersApiModel.*;

public class CreateOrderWithWorkerStrategy implements ICreateOrderStrategy {

	private CustomerService customerService;
	private RepairService repairService;
	private OrderService orderService;

	/**
	 * 
	 * @param workerId
	 */
	private IWorkerModel GetWorker(int workerId) {
		// TODO - implement CreateOrderWithWorkerStrategy.GetWorker
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	private boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability) {
		// TODO - implement CreateOrderWithWorkerStrategy.ChangeAvailability
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	private IAvailabilityModel CreateAvailability(IOrderModel order) {
		// TODO - implement CreateOrderWithWorkerStrategy.CreateAvailability
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		// TODO - implement CreateOrderWithWorkerStrategy.CreateOrder
		throw new UnsupportedOperationException();
	}

}