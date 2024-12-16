package System.WorkerApiModelLayer.WorkersApiModel;

import System.WorkerApiModelLayer.IAvailabilityState;

import java.sql.Connection;

public class AvailabilityState implements IAvailabilityState, State {

	private IAvailabilityModel[] Availabilities;
	private Connection connection;

	@Override
	public boolean InsertAvailability(IAvailabilityModel availability) {
		return false;
	}

	@Override
	public int UpdateAvailability(IAvailabilityModel availability) {
		return 0;
	}

	@Override
	public IAvailabilityModel SelectAvailability(int availabilityId) {
		return null;
	}

	@Override
	public Connection Connect() {
		return null;
	}

	@Override
	public boolean Disconnect() {
		return false;
	}
}