package System.CustomerApi.CustomerApiModel;

import System.CustomerApi.ICustomerState;
import System.OrdersApiModel.OrdersApiModel.OrderState;

public class State implements ICustomerState {

	private static CustomerModel[] customers = new CustomerModel[] {
			new CustomerModel(1,"Ula"),
			new CustomerModel(2, "Ola"),
			new CustomerModel(3,"Ela"),
			new CustomerModel(4, "Ala"),
	};
	private static State instance;

	@Override
	public CustomerModel GetCustomer(int customerId) {
		if (customers.length > customerId)
			return customers[customerId];
		else
			return null;
	}

	public static State getInstance() {
		if (instance == null) {
			instance = new State();
		}
		return instance;
	}
}