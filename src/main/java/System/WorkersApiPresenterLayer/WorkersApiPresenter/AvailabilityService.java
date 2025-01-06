package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.AvailabilityState;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;

public class AvailabilityService {

	private AvailabilityCreator availabilityCreator = new AvailabilityCreator();

	private IAvailabilityModel CreateNewAvailability(IAvailabilityModel availability, int WorkerId) {
		IAvailabilityModel model = availabilityCreator.CreateNewAvailability(availability, WorkerId);
		return model;
	}

	/**
	 * 
	 * @param WorkerId
	 * @param availability
	 */
	public boolean ChangeAvailability(int WorkerId, IAvailabilityModel availability) {
		IAvailabilityModel model = CreateNewAvailability(availability, WorkerId);

		if (model == null)
			return false;

		AvailabilityState state = AvailabilityState.getInstance();

		int result = state.UpdateAvailability(model);
		if (result == -1)
			return false;

		return true;
	}
}