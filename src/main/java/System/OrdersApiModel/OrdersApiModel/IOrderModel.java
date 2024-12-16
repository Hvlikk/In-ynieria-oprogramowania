package System.OrdersApiModel.OrdersApiModel;

public interface IOrderModel {

	OrderStatus GetStatus();

	int[] GetRepairIds();

	int GetWorkerId();

}