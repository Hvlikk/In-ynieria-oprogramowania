package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.IAvailabilityState;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;

public class AvailabilityService {

	private AvailabilityCreator AvailabilityCreator;
	private IAvailabilityState AvailabilityState;

	/**
	 * 
	 * @param IAvailabilityModel
	 */
	private IAvailabilityModel CreateNewAvailability(int IAvailabilityModel) {
		// TODO - implement AvailabilityService.CreateNewAvailability
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param WorkerId
	 * @param availability
	 */
	public boolean ChangeAvailability(int WorkerId, IAvailabilityModel availability) {
		// TODO - implement AvailabilityService.ChangeAvailability
		throw new UnsupportedOperationException();
	}

}