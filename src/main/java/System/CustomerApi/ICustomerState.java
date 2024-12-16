package System.CustomerApi;

public interface ICustomerState {

	/**
	 * 
	 * @param customerId
	 */
	CustomerModel GetCustomer(int customerId);

}