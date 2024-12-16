package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;

public class WorkerAvailabilityService {

	private IAvailabilityProvider provider = new AvailabilityProvider();

	/**
	 * 
	 * @param WorkerId
	 * @param availabilityModel
	 */
	public boolean ChangeAvailability(int WorkerId, IAvailabilityModel availabilityModel) {
		return provider.ChangeAvailability(WorkerId,availabilityModel);
	}

}