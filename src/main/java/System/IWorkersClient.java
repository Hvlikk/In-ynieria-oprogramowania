package System;


import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public interface IWorkersClient {

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