package System.WorkersApiPresenterLayer.WorkersApiPresenter;

import System.WorkerApiModelLayer.WorkersApiModel.IAvailabilityModel;
import System.WorkerApiModelLayer.WorkersApiModel.IWorkerModel;
import System.WorkersApiPresenterLayer.IWorkersClient;

public class WorkersController implements IWorkersClient {

	private WorkersService workerService = new WorkersService();
	private WorkerAvailabilityService workerAvailabilityService = new WorkerAvailabilityService();

	/**
	 * 
	 * @param worker
	 */
	public IWorkerModel CreateNewWorker(IWorkerModel worker) {
		System.out.println("Success call to WorkerApi\n");
		return workerService.CreateNewWorker(worker);
	}

	/**
	 * 
	 * @param worek
	 * @param availability
	 */
	@Override
	public boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability) {
		System.out.println("Success call to WorkerApi\n");
		return workerAvailabilityService.ChangeAvailability(worek.GetId(), availability);
	}

	/**
	 * 
	 * @param workerId
	 */
	public IWorkerModel GetWorker(int workerId) {
		System.out.println("Success call to WorkerApi\n");
		return  workerService.GetWorker(workerId);
	}

}