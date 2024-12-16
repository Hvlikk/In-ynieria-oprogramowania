package System.CustomerApi.CustomerApi;

import System.CustomerApi.CustomerApiModel.CustomerModel;
import System.CustomerApi.CustomerApiModel.State;
import System.CustomerApi.ICustomerClient;

public class CustomerController implements ICustomerClient {

    @Override
    public CustomerModel GetCustomer(int customerId) {
        System.out.println("Success call to CustomerApi\n");
        return State.getInstance().GetCustomer(customerId);
    }
}