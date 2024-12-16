import CustomerApi.CustomerApiModel.*;

public interface ICustomerClient {

	/**
	 * 
	 * @param customerId
	 */
	CustomerModel GetCustomer(int customerId);

}