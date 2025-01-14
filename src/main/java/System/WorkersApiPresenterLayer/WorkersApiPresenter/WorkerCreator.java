package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkerApiModelLayer.WorkersApiModel.WorkerState;

public class WorkerCreator {

	/**
	 * 
	 * @param model
	 */
	public IWorkerModel CreateNewWorker(IWorkerModel model) throws Exception {
		if (WorkerState.getInstance().InsertWorker(model))
			return model;
		return null;
	}

}