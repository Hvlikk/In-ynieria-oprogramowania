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
	bool UpdateWorkerAvailability(int workerId, IAvailabilityModel availability);

}