package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public class CreateProcessor implements IOrderCreation {
    @Override
    public boolean Handle(IAction action) {
        return false;
    }

    @Override
    public void setNext(IOrderCreation next) {

    }
}