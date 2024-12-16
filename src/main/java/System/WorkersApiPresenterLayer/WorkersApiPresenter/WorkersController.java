package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkersApiPresenterLayer.IWorkersClient;

public class WorkersController implements IWorkersClient {

	private WorkersService workerService;
	private WorkerAvailabilityService workerAvailabilityService;

	/**
	 * 
	 * @param worker
	 */
	public IWorkerModel CreateNewWorker(IWorkerModel worker) {
		// TODO - implement WorkersController.CreateNewWorker
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	@Override
	public boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability) {
		// TODO - implement WorkersController.ChangeAvailability
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param workerId
	 */
	public IWorkerModel GetWorker(int workerId) {
		// TODO - implement WorkersController.GetWorker
		throw new UnsupportedOperationException();
	}

}