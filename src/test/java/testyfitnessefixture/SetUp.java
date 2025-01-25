package testyfitnessefixture;

import System.WorkerApiModelLayer.WorkersApiModel.WorkerState;
import fit.Fixture;

public class SetUp extends Fixture {
    static WorkerState state;
    public SetUp() {
        state = WorkerState.getInstance();
    }
}
