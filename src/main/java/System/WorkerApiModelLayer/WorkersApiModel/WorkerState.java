package System.WorkerApiModelLayer.WorkersApiModel;

import System.WorkerApiModelLayer.IWorkerState;

import java.sql.Connection;
import java.util.ArrayList;

public class WorkerState implements IWorkerState, State {

	private static ArrayList<WorkerModel> workers = new ArrayList<>();
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
		if (worker.GetId() < workers.size() && worker.GetId() > 0  ) {
			workers.add((WorkerModel) worker);
			System.out.println("Success insert worker\n");
			return true;
		}
		return false;
	}

	@Override
	public int UpdateWorker(IWorkerModel worker) {
		int index  = worker.GetId();
		workers.set(index, (WorkerModel) worker);
		return worker.GetId();
	}

	@Override
	public IWorkerModel GetWorkerById(int workerId) {
		return workers.get(workerId);
	}

	@Override
	public WorkerModel DeleteWorker(int workerId) {
		WorkerModel worker = workers.get(workerId);
		workers.remove(workerId);
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