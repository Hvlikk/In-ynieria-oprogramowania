package System.WorkersApi;

public interface IAvailabilityStatee {

	AvailabilityState GetState();

	void PatchState();

}