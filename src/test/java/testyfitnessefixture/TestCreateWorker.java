package testyfitnessefixture;
import System.WorkerApiModelLayer.WorkersApiModel.WorkerModel;
import fit.ColumnFixture;
public class TestCreateWorker extends ColumnFixture{
    String dane[];

    WorkerModel worker = new WorkerModel(
                                "Alice",
                                "Johnson",
                                45000,
                                "Developer",
                                3,
                                true);

    public boolean CreateWorker() throws IndexOutOfBoundsException{
        int IdToInsert = WorkerId(worker.Id);
        try{
            SetUp.state.InsertWorker(worker);
            return IdToInsert == WorkerId(worker.GetId());
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int WorkerId(Integer id) {
        return SetUp.state.GetWorkerById(id).GetId();
    }
}
