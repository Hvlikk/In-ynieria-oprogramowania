package System.WorkerApiModelLayer.WorkersApiModel;

public class WorkerModel implements IWorkerModel {

	public String Name;
	public String Surname;
	public int Salary;
	public String Profession;
	public int Id;
	public boolean Busy;

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