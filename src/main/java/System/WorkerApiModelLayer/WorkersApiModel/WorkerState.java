package System.WorkerApiModelLayer.WorkersApiModel;

import System.WorkerApiModelLayer.IWorkerState;

import java.sql.Connection;

public class WorkerState implements IWorkerState, State {

	private IWorkerModel[] Workers;
	private Connection connection;

	@Override
	public boolean InsertWorker(IWorkerModel worker) {
		return false;
	}

	@Override
	public int UpdateWorker(IWorkerModel worker) {
		return 0;
	}

	@Override
	public IWorkerModel GetWorkerById(int workerId) {
		return null;
	}

	@Override
	public IWorkerModel DeleteWorker(int workerId) {
		return null;
	}

	@Override
	public Connection Connect() {
		return null;
	}

	@Override
	public boolean Disconnect() {
		return false;
	}
}