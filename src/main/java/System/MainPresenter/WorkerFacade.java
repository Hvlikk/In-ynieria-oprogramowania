package System.MainPresenter;

public class WorkerFacade implements IOrderFacade {

	private WorkerService workerService;

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
	public boolean ChangeAvailability(IWorkerModel worek, IAvailabilityModel availability) {
		// TODO - implement WorkerFacade.ChangeAvailability
		throw new UnsupportedOperationException();
	}

}