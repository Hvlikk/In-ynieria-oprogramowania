package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import WorkersApiPresenterLayer.*;
import WorkerApiModelLayer.WorkersApiModel.*;

public class WorkersController implements IWorkersClient {

	private WorkersService workerService;
	private WorkerAvailabilityService workerAvailabilityService;

	/**
	 * 
	 * @param worker
	 */
	public WorkersApi.IWorkerModel CreateNewWorker(IWorkerModel worker) {
		// TODO - implement WorkersController.CreateNewWorker
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
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