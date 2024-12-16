package System.OrdersApiPresenterLayer.OrdersApiPresenter;

import System.OrdersApiModel.OrdersApiModel.IDeviceModel;
import System.OrdersApiPresenterLayer.IRepairsClient;

public class RepairsController implements IRepairsClient {

	private IRepairProvider provider;

	/**
	 * 
	 * @param device
	 */
	public int CreateDevice(IDeviceModel device) {
		// TODO - implement RepairsController.CreateDevice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param deviceId
	 */
	@Override
	public int CreateRepair(int deviceId) {
		// TODO - implement RepairsController.CreateRepair
		throw new UnsupportedOperationException();
	}

}