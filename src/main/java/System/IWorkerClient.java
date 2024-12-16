package System;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public interface IWorkerClient {

	/**
	 * 
	 * @param workerId
	 */
	IWorkerModel GetWorker(int workerId);

	/**
	 * 
	 * @param workerId
	 * @param availability
	 */
	boolean UpdateWorkerAvailability(int workerId, IAvailabilityModel availability);

}