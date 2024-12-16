package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public interface IRepairCreator {

	/**
	 * 
	 * @param device
	 */
	IRepairModel CreateRepair(IDeviceModel device);

}