package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.WorkerApiModelLayer.WorkersApiModel.AvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public class OrderFacade implements IOrderFacade {

	private OrderCreation orderCreation = new OrderCreation();
	private WorkerService workerService = new WorkerService();
	private OrderService orderService = new OrderService();

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {

		ICreateOrderStrategy strategy;
		if (workerId == -1) {
			strategy = new CreateSimpleOrderStrategy();
			System.out.println("Wybrano strategie bez pracownika\n");
		}else {
			strategy = new CreateOrderWithWorkerStrategy();
			System.out.println("Wybrano strategie z pracownikiem\n");
		}

		orderCreation.SetStrategy(strategy);

		return orderCreation.CreateOrder(device,order,workerId,clientId);
	}

	/**
	 * 
	 * @param worker
	 * @param order
	 */
	@Override
	public boolean ChangeWorkerForOrder(IWorkerModel worker, IOrderModel order) {
		IWorkerModel model = workerService.GetWorker(worker.GetId());

		if (model.IsBusy())
			return false;

		AvailabilityModel availabilityModel = new AvailabilityModel();
		if (!workerService.ChangeAvailability(model,availabilityModel))
			return false;

		return orderService.ChangeOrder(order);
	}

}