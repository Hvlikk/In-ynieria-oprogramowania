package System.WorkersApiPresenterLayer;

import WorkerApiModelLayer.WorkersApiModel.*;

public interface IWorkersClient {

	/**
	 * 
	 * @param worker
	 */
	WorkersApi.IWorkerModel CreateNewWorker(IWorkerModel worker);

	/**
	 * 
	 * @param workerId
	 */
	IWorkerModel GetWorker(int workerId);

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability);

}