package System.OrdersApiModel.OrdersApiModel;

public class DeviceModel implements IDeviceModel {

	private String Mark;
	private DeviceCondition Condition;
	private String Comment;
	private DevicePart[] Parts;

	@Override
	public DevicePart[] GetBrokenParts() {
		return new DevicePart[0];
	}

	@Override
	public DevicePart[] GetGoodParts() {
		return new DevicePart[0];
	}
}