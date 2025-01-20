package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkerApiModelLayer.WorkersApiModel.WorkerState;

public class WorkerCreator {

	/**
	 * 
	 * @param model
	 */
	public IWorkerModel CreateNewWorker(IWorkerModel model) {
		if (WorkerState.getInstance().InsertWorker(model))
			return model;
		return null;
	}

}