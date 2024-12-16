package System.OrdersApiModel.OrdersApiModel;

import System.OrdersApiPresenterLayer.IOrderState;

import java.sql.Connection;

public class OrderState implements IOrderState, State {

	private IOrderModel[] orders;
	private Connection connection;

	@Override
	public boolean Disconnect() {
		return false;
	}

	@Override
	public Connection Connect() {
		return null;
	}

	@Override
	public boolean InsertOrder(IOrderModel order) {
		return false;
	}

	@Override
	public int UpdateOrder(IOrderModel order) {
		return 0;
	}

	@Override
	public IOrderModel GetOrderById(int orderId) {
		return null;
	}

	@Override
	public IOrderModel DeleteOrder(int orderId) {
		return null;
	}

	@Override
	public IOrderModel GetOrder(Integer id) {
		return null;
	}
}