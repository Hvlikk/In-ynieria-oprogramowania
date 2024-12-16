package System.WorkerApiModelLayer.WorkersApiModel;

import java.sql.Connection;

public interface State {

	Connection Connect();

	boolean Disconnect();

}