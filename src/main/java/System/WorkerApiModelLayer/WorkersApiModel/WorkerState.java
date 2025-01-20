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
		if (worker.GetId() < 0)
			throw new IndexOutOfBoundsException("Worker ID must be non-negative");
		workers.add((WorkerModel) worker);
		System.out.println("Success insert worker\n");
		return true;
	}

	@Override
	public int UpdateWorker(IWorkerModel worker) {
		WorkerModel w = (WorkerModel) GetWorkerById(worker.GetId());
		if (w == null) {
			throw new NullPointerException("Worker doesn't exist");
		}
		if (worker.GetSalary() < 0)
			throw new IllegalArgumentException("Salary cannot be negative.");

		int index  = workers.indexOf(w);

		workers.set(index, (WorkerModel) worker);
		return worker.GetId();
	}

	@Override
	public IWorkerModel GetWorkerById(int workerId) {
		return workers.stream()
				.filter(worker -> worker.GetId() == workerId)
				.findFirst()
				.orElse(null);
	}

	@Override
	public WorkerModel DeleteWorker(int workerId) throws Exception {
		IWorkerModel worker = GetWorkerById(workerId);

		if (worker == null)
			throw new Exception("Worker with given Id don't exist");

		workers.remove(worker);

		return (WorkerModel)worker;
	}

	public void Clear() {
		workers.clear();
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