package System.CustomerApi.CustomerApiModel;

import System.CustomerApi.ICustomerState;

public class State implements ICustomerState {

	private CustomerModel[] customers;

	@Override
	public CustomerModel GetCustomer(int customerId) {
		return null;
	}
}