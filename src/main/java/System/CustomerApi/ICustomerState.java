package System.CustomerApi;

import System.CustomerApi.CustomerApiModel.CustomerModel;

public interface ICustomerState {

	/**
	 * @param customerId
	 */
	CustomerModel GetCustomer(int customerId);

}