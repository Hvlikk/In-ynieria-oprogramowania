package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public class CreateProcessor implements IOrderCreation {

    IOrderCreation next;

    @Override
    public Action Handle(IAction action) {
        switch (action.GetAction()) {
            case ActionEnum.SetWorker -> {
                System.out.println("Success set client");
                return new Action(ActionEnum.SetClient);
            }
            case ActionEnum.SetClient -> {
                System.out.println("Success set client");
                return new Action(ActionEnum.SetDevice);
            }
            case ActionEnum.SetDevice -> {
                System.out.println("Success set device");
                return new Action(ActionEnum.Insert);
            }
            default -> {
                return new Action(ActionEnum.Insert);
            }
        }
    }

    @Override
    public void setNext(IOrderCreation next) {
        this.next = next;
    }
}