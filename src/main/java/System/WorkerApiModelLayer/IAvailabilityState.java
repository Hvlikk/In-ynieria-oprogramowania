package System.WorkerApiModelLayer;

import WorkerApiModelLayer.WorkersApiModel.*;

public interface IAvailabilityState {

	/**
	 * 
	 * @param availability
	 */
	boolean InsertAvailability(IAvailabilityModel availability);

	/**
	 * 
	 * @param availability
	 */
	int UpdateAvailability(IAvailabilityModel availability);

	/**
	 * 
	 * @param availabilityId
	 */
	IAvailabilityModel SelectAvailability(int availabilityId);

}