package System.WorkersApiPresenterLayer.WorkersApiPresenter;

public interface IAvailabilityProvider {

	/**
	 * 
	 * @param WorkerId
	 * @param IAvailabilityModel
	 */
	boolean ChangeAvailability(int WorkerId, int IAvailabilityModel);

}