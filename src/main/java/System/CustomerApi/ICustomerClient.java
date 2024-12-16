package System.CustomerApi;

public interface ICustomerClient {

	/**
	 * 
	 * @param customerId
	 */
	CustomerModel GetCustomer(int customerId);

}