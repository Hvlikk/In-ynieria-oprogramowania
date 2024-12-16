package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public class UpdateProcessor implements IOrderCreation {
    @Override
    public Action Handle(IAction action) {
        switch (action.GetAction()) {
            case ActionEnum.SetWorker -> {
                System.out.println("Success set worker\n");
                return new Action(ActionEnum.SetClient);
            }
            case ActionEnum.SetClient -> {
                System.out.println("Success set client\n");
                return new Action(ActionEnum.SetDevice);
            }
            case ActionEnum.SetDevice -> {
                System.out.println("Success set device\n");
                return new Action(ActionEnum.Insert);
            }
            default -> {
                return new Action(ActionEnum.Insert);
            }
        }
    }

    @Override
    public void setNext(IOrderCreation next) {

    }
}