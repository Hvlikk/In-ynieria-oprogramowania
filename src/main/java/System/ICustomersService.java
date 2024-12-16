package System;

import System.CustomerApi.CustomerApiModel.CustomerModel;

public interface ICustomersService {
	/**
	 * 
	 * @param customerId
	 */
	CustomerModel GetCustomer(String customerId);

}