package System.OrdersApiModel.OrdersApiModel;

import java.util.Date;

public class RepairModel implements IRepairModel {

	private Date StartDate;
	private IDeviceModel[] devices;

	@Override
	public boolean IsReady() {
		return false;
	}
}