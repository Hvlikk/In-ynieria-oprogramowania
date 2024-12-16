package System.OrdersApiModel.OrdersApiModel;

import java.util.Date;

public class OrderModel implements IOrderModel {

	private OrderStatus Status;
	private int WorkerId;
	private int[] RepairId;
	private Date StartDate;

	@Override
	public OrderStatus GetStatus() {
		return null;
	}

	@Override
	public int[] GetRepairIds() {
		return new int[0];
	}

	@Override
	public int GetWorkerId() {
		return 0;
	}
}