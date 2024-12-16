package System.OrdersApiModel.OrdersApiModel;

import System.OrdersApiPresenterLayer.IRepairState;

import java.sql.Connection;

public class RepairState implements IRepairState, State {

	private IRepairModel[] repairs;
	private Connection connection;

	@Override
	public boolean Disconnect() {
		return false;
	}

	@Override
	public Connection Connect() {
		return null;
	}

	@Override
	public boolean InsertRepair(IRepairModel repair) {
		return false;
	}

	@Override
	public int UpdateRepair(IRepairModel repair) {
		return 0;
	}

	@Override
	public IDeviceModel SelectDevice(int deviceId) {
		return null;
	}

	@Override
	public IRepairModel SelectRepair(int repairId) {
		return null;
	}
}