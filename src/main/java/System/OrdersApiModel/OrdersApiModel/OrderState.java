package System.OrdersApiModel.OrdersApiModel;

import OrdersApiPresenterLayer.*;

public class OrderState implements IOrderState, State {

	private IOrderModel[] orders;
	private Connection connection;

}