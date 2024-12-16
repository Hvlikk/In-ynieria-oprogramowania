package System.WorkerApiModelLayer.WorkersApiModel;

import java.util.Date;

public interface IAvailabilityModel {

	int GetWorkerId();

	Date GetFromDate();

	Date GetToDate();

	Availability GetType();

}