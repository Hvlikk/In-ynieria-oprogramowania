package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

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

	@Override
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		return null;
	}
}