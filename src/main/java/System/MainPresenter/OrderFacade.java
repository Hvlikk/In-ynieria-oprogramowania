package System.MainPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
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
		if (workerId == -1) {
			orderCreation.orderContext.SetStrategy(new CreateSimpleOrderStrategy());
			System.out.println("Wybrano strategie bez pracownika\n");
		}else {
			orderCreation.orderContext.SetStrategy(new CreateOrderWithWorkerStrategy());
			System.out.println("Wybrano strategie z pracownikiem\n");
		}

		return orderCreation.orderContext.CreateOrder(device,order,workerId,clientId);
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