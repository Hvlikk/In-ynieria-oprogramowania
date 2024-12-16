package System.CustomerApi;

import System.CustomerApi.CustomerApiModel.CustomerModel;

public interface ICustomerClient {

	/**
	 * @param customerId
	 */
	CustomerModel GetCustomer(int customerId);

}