package System.WorkersApiPresenterLayer.WorkersApiPresenter;

public interface IAvailabilityProvider {

	/**
	 * 
	 * @param WorkerId
	 * @param IAvailabilityModel
	 */
	boolean ChangeAvailability(integer WorkerId, int IAvailabilityModel);

}