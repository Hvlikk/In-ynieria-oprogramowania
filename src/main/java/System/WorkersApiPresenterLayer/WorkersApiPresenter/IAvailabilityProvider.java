package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.AvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;

public interface IAvailabilityProvider {

	/**
	 * 
	 * @param WorkerId
	 * @param model
	 */
	boolean ChangeAvailability(int WorkerId, IAvailabilityModel model);

}