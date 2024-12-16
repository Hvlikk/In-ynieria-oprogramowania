package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public interface IOrderCreation {

	IOrderCreation next = null;

	/**
	 * 
	 * @param action
	 */
	boolean Handle(IAction action);

	/**
	 * 
	 * @param next
	 */
	void setNext(IOrderCreation next);

}