package System.WorkerApiModelLayer.WorkersApiModel;

import System.WorkerApiModelLayer.IWorkerState;

import java.sql.Connection;

public class WorkerState implements IWorkerState, State {

	private static WorkerModel[] workers = new WorkerModel[] {
			new WorkerModel(),
			new WorkerModel(),
			new WorkerModel(),
			new WorkerModel(),
			new WorkerModel(),
	};
	private static WorkerState instance;



	private IWorkerModel[] Workers;
	private Connection connection;

	public static WorkerState getInstance() {
		if (instance == null) {
			instance = new WorkerState();
		}
		return instance;
	}

	@Override
	public boolean InsertWorker(IWorkerModel worker) {
		if (worker.GetId() < workers.length) {
			workers[worker.GetId()] = (WorkerModel) worker;
			System.out.println("Success insert worker\n");
			return true;
		}
		return false;
	}

	@Override
	public int UpdateWorker(IWorkerModel worker) {
		workers[worker.GetId()] = (WorkerModel) worker;
		return worker.GetId();
	}

	@Override
	public IWorkerModel GetWorkerById(int workerId) {
		return workers[workerId];
	}

	@Override
	public WorkerModel DeleteWorker(int workerId) {
		WorkerModel worker = workers[workerId];
		workers[workerId] = null;
		return worker;
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