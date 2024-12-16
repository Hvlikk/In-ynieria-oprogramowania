package System.WorkerApiModelLayer.WorkersApiModel;

public interface IAvailabilityModel {

	int GetWorkerId();

	Date GetFromDate();

	Date GetToDate();

	Availability GetType();

}