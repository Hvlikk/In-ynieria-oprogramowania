package System.MainPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkersApiPresenterLayer.IWorkersClient;
import System.WorkersApiPresenterLayer.WorkersApiPresenter.WorkersController;

public class WorkerService {

	private IWorkersClient client = new WorkersController();

	/**
	 * 
	 * @param workerId
	 */
	public IWorkerModel GetWorker(int workerId) {
		return client.GetWorker(workerId);
	}

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	public boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability) {
		return client.ChangeAvailability(worek,availability);
	}

}