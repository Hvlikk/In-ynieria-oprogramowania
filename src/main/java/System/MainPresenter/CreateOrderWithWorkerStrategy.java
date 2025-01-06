package System.MainPresenter;

import System.CustomerApi.CustomerApiModel.CustomerModel;
import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.WorkerApiModelLayer.WorkersApiModel.AvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public class CreateOrderWithWorkerStrategy implements ICreateOrderStrategy {

	private CustomerService customerService = new CustomerService();
	private RepairService repairService = new RepairService();
	private OrderService orderService = new OrderService();
	private WorkerService workerService = new WorkerService();

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
		IWorkerModel worker = workerService.GetWorker(workerId);

		boolean busy = worker.IsBusy();
		if (busy)
			return null;

		CustomerModel customer = customerService.GetCustomer(clientId);

		if (customer == null)
			return null;

		AvailabilityModel availabilityModel = new AvailabilityModel();

		workerService.ChangeAvailability(worker,availabilityModel);

		return orderService.CreateOrder(device,order,worker.GetId(),customer.getId());
	}
}