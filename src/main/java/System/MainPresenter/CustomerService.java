package System.MainPresenter;

import System.CustomerApi.CustomerApi.CustomerController;
import System.CustomerApi.CustomerApiModel.CustomerModel;
import System.CustomerApi.ICustomerClient;

public class CustomerService {

	private ICustomerClient client = new CustomerController();

	/**
	 * 
	 * @param customerId
	 */
	public CustomerModel GetCustomer(int customerId) {
		return client.GetCustomer(customerId);
	}

}