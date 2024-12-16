package System.OrdersApiPresenterLayer;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiModel.OrdersApiModel.IRepairModel;

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
	 * @param deviceId
	 */
	IDeviceModel SelectDevice(int deviceId);

	/**
	 * @param repairId
	 */
	IRepairModel SelectRepair(int repairId);

}