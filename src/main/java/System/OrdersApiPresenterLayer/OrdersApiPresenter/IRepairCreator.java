package System.OrdersApiPresenterLayer.OrdersApiPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;

public interface IRepairCreator {

	/**
	 * 
	 * @param device
	 */
	IRepairModel CreateRepair(IDeviceModel device);

}