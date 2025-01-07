package System.WorkerApiModelLayer.WorkersApiModel;

public class WorkerModel implements IWorkerModel {

	private String Name;
	private String Surname;
	private int Salary;
	private String Profession;
	private int Id;
	private boolean Busy;

	public WorkerModel() {

	}

	@Override
	public String GetName() {
		return "";
	}

	@Override
	public String GetSurname() {
		return "";
	}

	@Override
	public int GetSalary() {
		return 0;
	}

	@Override
	public String GetProfession() {
		return "";
	}

	@Override
	public int GetId() {
		return 0;
	}

	@Override
	public boolean IsBusy() {
		return false;
	}
}