package System.OrdersApiModel.OrdersApiModel;

import System.OrdersApiPresenterLayer.IOrderState;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class OrderState implements IOrderState {

	private static OrderState instance;
	private static List<IOrderModel> orders;
	private static Connection connection;

	private OrderState() {
		orders = new LinkedList<IOrderModel>();
		connection = null;
	}

	public static OrderState getInstance() {
		if (instance == null) {
			instance = new OrderState();
		}
		return instance;
	}

	@Override
	public boolean Disconnect() {
		System.out.println("Success disconnection with OrdersDB\n");
		return true;
	}

	@Override
	public Connection Connect() {
		System.out.println("Success connection with OrdersDB\n");
		return null;
	}

	@Override
	public boolean InsertOrder(IOrderModel order) {
		if (order != null) {
			System.out.println("Success insertion order\n");
			orders.add(order);
			return true;
		}
		return false;
	}

	@Override
	public int UpdateOrder(IOrderModel order) {
		orders.set(order.GetId(),order);
		System.out.println("Success update order\n");
		return order.GetId();
	}

	@Override
	public IOrderModel GetOrderById(int orderId) {
		for (IOrderModel order : orders) {
			if (order != null && order.GetId() == orderId) {
				return order;
			}
		}
		return null;
	}

	@Override
	public IOrderModel DeleteOrder(int orderId) {
		IOrderModel deletedOrder = orders.get(orderId);
		orders.remove(deletedOrder);
		return deletedOrder;
	}

	@Override
	public IOrderModel GetOrder(Integer id) {
		return GetOrderById(id);
	}
}
