package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.AvailabilityState;
import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;

public class AvailabilityCreator {

	public IAvailabilityModel CreateNewAvailability(IAvailabilityModel model, int workerId) {
		AvailabilityState state = AvailabilityState.getInstance();
		model.SetId(workerId);

		boolean success = state.InsertAvailability(model);
		if(success)
			return model;
		else
			return null;
	}

}