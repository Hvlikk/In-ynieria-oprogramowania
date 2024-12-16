package System.WorkerApiModelLayer.WorkersApiModel;

import System.WorkerApiModelLayer.IAvailabilityState;

import java.sql.Connection;

public class AvailabilityState implements IAvailabilityState, State {

	private static IAvailabilityModel[] availabilityModels = new IAvailabilityModel[] {
			new AvailabilityModel(),
			new AvailabilityModel(),
			new AvailabilityModel(),
			new AvailabilityModel(),
	};
	private static AvailabilityState instance;



	private IWorkerModel[] Workers;
	private Connection connection;

	public static AvailabilityState getInstance() {
		if (instance == null) {
			instance = new AvailabilityState();
		}
		return instance;
	}

	@Override
	public boolean InsertAvailability(IAvailabilityModel availability) {
		if (availability.GetId() >= availabilityModels.length)
			return false;

		availabilityModels[availability.GetId()] = availability;
		System.out.println("Success insert availability\n");
		return true;
	}

	@Override
	public int UpdateAvailability(IAvailabilityModel availability) {
		availabilityModels[availability.GetId()] = availability;
		System.out.println("Success update availability\n");
		return availability.GetId();
	}

	@Override
	public IAvailabilityModel SelectAvailability(int availabilityId) {
		return availabilityModels[availabilityId];
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