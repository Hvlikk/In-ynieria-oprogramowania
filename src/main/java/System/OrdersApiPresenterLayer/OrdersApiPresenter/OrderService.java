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

		while (action.GetAction() != ActionEnum.Insert) {
			action = orderCreationChain.Handle(action);
		}

		OrderState.getInstance().InsertOrder(order);

		return order;
	}

	/**
	 * 
	 * @param order
	 */
	public int UpdateOrder(IOrderModel order) {
		// TODO - implement OrderService.UpdateOrder
		throw new UnsupportedOperationException();
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