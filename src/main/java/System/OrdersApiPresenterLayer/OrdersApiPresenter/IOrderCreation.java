package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public interface IOrderCreation {

	IOrderCreation next = null;

	/**
	 * 
	 * @param action
	 */
	Action Handle(IAction action);

	/**
	 * 
	 * @param next
	 */
	void setNext(IOrderCreation next);

}