package System.MainPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public interface IWorkerFacade {

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability);

	/**
	 * 
	 * @param workerId
	 */
	IWorkerModel GetWorker(int workerId);

}