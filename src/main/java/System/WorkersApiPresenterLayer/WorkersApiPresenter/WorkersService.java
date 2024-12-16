package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkerApiModelLayer.WorkersApiModel.WorkerState;

public class WorkersService {

	private WorkerCreator workerCreator = new WorkerCreator();

	/**
	 * 
	 */
	public IWorkerModel CreateNewWorker(IWorkerModel workerModel) {
		return workerCreator.CreateNewWorker(workerModel);
	}

	/**
	 * 
	 * @param Id
	 */
	public IWorkerModel GetWorker(int Id) {
		return WorkerState.getInstance().GetWorkerById(Id);
	}

}