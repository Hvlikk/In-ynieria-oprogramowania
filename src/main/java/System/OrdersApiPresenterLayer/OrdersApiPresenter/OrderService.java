package System.OrdersApiPresenterLayer.OrdersApiPresenter;

import System.MainPresenter.OrderCreation;
import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IOrderModel;
import System.OrdersApiModel.OrdersApiModel.OrderState;
import System.OrdersApiPresenterLayer.IOrderState;

public class OrderService {

	private IOrderCreation orderCreationChain;

	/**
	 * 
	 * @param device
	 * @param order
	 * @param workerId
	 * @param clientId
	 */
	public IOrderModel CreateOrder(IDeviceModel device, IOrderModel order, int workerId, int clientId) {
		Action action = new Action(ActionEnum.SetClient);

		this.orderCreationChain = new CreateProcessor();

		orderCreationChain.Handle(action);

		while (action.GetAction() != ActionEnum.Insert) {
			action = orderCreationChain.Handle(action);
		}

		OrderState instance = OrderState.getInstance();

		instance.InsertOrder(order);

		return order;
	}

	/**
	 * 
	 * @param order
	 */
	public int UpdateOrder(IOrderModel order) {
		IAction action = new Action(ActionEnum.SetWorker);
		this.orderCreationChain = new UpdateProcessor();

		orderCreationChain.Handle(action);

		return OrderState.getInstance().UpdateOrder(order);
	}

	/**
	 * 
	 * @param id
	 */
	public IOrderModel GetOrder(Integer id) {
		// TODO - implement OrderService.GetOrder
		throw new UnsupportedOperationException();
	}

}