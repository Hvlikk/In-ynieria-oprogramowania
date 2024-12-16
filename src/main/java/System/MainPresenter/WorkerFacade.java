package System.MainPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;

public class WorkerFacade implements IWorkerFacade {

	private WorkerService workerService = new WorkerService();



	/**
	 * 
	 * @param workerId
	 */
	public IWorkerModel GetWorker(int workerId) {
		// TODO - implement WorkerFacade.GetWorker
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	@Override
	public boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability) {
		return workerService.ChangeAvailability(worek,availability);
	}

}