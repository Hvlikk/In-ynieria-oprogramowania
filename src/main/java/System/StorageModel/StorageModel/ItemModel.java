package System.StorageModel.StorageModel;

public class ItemModel implements IItemModel {

	private int partID;
	private int quantity;

	public ItemModel(int partID, int quantity) {
		if (partID < 0) {
			throw new IllegalArgumentException("partID cannot be negative");
		}
		if (quantity < 0) {
			throw new IllegalArgumentException("quantity cannot be negative");
		}
		this.partID = partID;
		this.quantity = quantity;
	}

	public int GetPartID() {
		return this.partID;
	}

	public int GetQuantity() {
		return this.quantity;
	}

	public void SetPartID(int partID) {
		if (partID < 0) {
			throw new IllegalArgumentException("partID cannot be negative");
		}
		this.partID = partID;
	}

	public void SetQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("quantity cannot be negative");
		}
		this.quantity = quantity;
	}
}