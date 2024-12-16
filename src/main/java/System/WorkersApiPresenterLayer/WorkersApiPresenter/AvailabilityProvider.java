package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;

public class AvailabilityProvider implements IAvailabilityProvider {

	private AvailabilityService availabilityService = new AvailabilityService();

	@Override
	public boolean ChangeAvailability(int WorkerId, IAvailabilityModel model) {
		return availabilityService.ChangeAvailability(WorkerId, model);
	}
}