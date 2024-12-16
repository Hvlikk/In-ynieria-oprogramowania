package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.AvailabilityState;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;

public class AvailabilityService {

	private AvailabilityCreator availabilityCreator = new AvailabilityCreator();

	/**
	 * 
	 * @param id
	 */
	private IAvailabilityModel CreateNewAvailability(int id) {
		IAvailabilityModel model = availabilityCreator.CreateNewAvailability();
		model.SetId(id);

		if (AvailabilityState.getInstance().InsertAvailability(model))
			return model;

		return null;
	}

	/**
	 * 
	 * @param WorkerId
	 * @param availability
	 */
	public boolean ChangeAvailability(int WorkerId, IAvailabilityModel availability) {
		int result = AvailabilityState.getInstance().UpdateAvailability(availability);
		if (result > -1)
			return true;

		return false;
	}

}