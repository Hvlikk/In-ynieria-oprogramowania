package System.OrdersApiPresenterLayer;

import OrdersApiModel.OrdersApiModel.*;

public interface IRepairState {

	/**
	 * 
	 * @param repair
	 */
	boolean InsertRepair(IRepairModel repair);

	/**
	 * 
	 * @param repair
	 */
	int UpdateRepair(IRepairModel repair);

	/**
	 * 
	 * @param deviceId
	 */
	IDeviceModel SelectDevice(int deviceId);

	/**
	 * 
	 * @param repairId
	 */
	IRepairModel SelectRepair(int repairId);

}