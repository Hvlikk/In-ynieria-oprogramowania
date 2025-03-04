package System.WorkerApiModelLayer;

import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkerApiModelLayer.WorkersApiModel.WorkerState;

public interface IWorkerState {

	/**
	 * 
	 * @param worker
	 */
	boolean InsertWorker(IWorkerModel worker) throws Exception;

	/**
	 * 
	 * @param worker
	 */
	int UpdateWorker(IWorkerModel worker);

	/**
	 * 
	 * @param workerId
	 */
	IWorkerModel GetWorkerById(int workerId);

	/**
	 * 
	 * @param workerId
	 */
	IWorkerModel DeleteWorker(int workerId) throws Exception;

	static WorkerState getInstance() {return null;};

}