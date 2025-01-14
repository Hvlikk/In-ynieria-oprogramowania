package System.WorkersApiPresenterLayer;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public interface IWorkersClient {

	/**
	 * 
	 * @param worker
	 */
	IWorkerModel CreateNewWorker(IWorkerModel worker) throws Exception;

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