package System.WorkerApiModelLayer.WorkersApiModel;

import java.util.Date;

public class AvailabilityModel implements IAvailabilityModel {

	private int WorkerId;
	private Date From;
	private Date To;
	private Availability Type;

	@Override
	public int GetWorkerId() {
		return 0;
	}

	@Override
	public Date GetFromDate() {
		return null;
	}

	@Override
	public Date GetToDate() {
		return null;
	}

	@Override
	public Availability GetType() {
		return null;
	}
}