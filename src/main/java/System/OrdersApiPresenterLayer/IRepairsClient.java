package System.OrdersApiPresenterLayer;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;

public interface IRepairsClient {

	/**
	 * 
	 * @param device
	 */
	int CreateDevice(IDeviceModel device);

	/**
	 * 
	 * @param deviceId
	 */
	int CreateRepair(int deviceId);

}