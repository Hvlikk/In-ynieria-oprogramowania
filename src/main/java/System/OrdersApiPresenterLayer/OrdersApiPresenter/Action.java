package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public class Action implements IAction {

	public Action(ActionEnum action) {
		this.action = action;
	}

	private ActionEnum action;

	@Override
	public ActionEnum GetAction() {
		return this.action;
	}
}