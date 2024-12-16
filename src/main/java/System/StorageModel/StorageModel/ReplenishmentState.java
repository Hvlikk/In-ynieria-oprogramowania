package System.StorageModel.StorageModel;
import System.IReplenishmentState;
import System.IReplenishment;

public class ReplenishmentState implements IReplenishmentState {

	public void InsertOrder() {
		// TODO - implement ReplenishmentState.InsertOrder
		throw new UnsupportedOperationException();
	}

	public void DeleteOrder() {
		// TODO - implement ReplenishmentState.DeleteOrder
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean InsertOrder(IReplenishment order) {
		return false;
	}

	@Override
	public boolean DeleteOrder(int orderID) {
		return false;
	}
}