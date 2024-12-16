package System.MainPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkersApiPresenterLayer.IWorkersClient;

public class WorkerService {

	private IWorkersClient client;

	/**
	 * 
	 * @param workerId
	 */
	public IWorkerModel GetWorker(int workerId) {
		// TODO - implement WorkerService.GetWorker
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	public boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability) {
		// TODO - implement WorkerService.ChangeAvailability
		throw new UnsupportedOperationException();
	}

}