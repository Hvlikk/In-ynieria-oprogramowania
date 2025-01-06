package System.OrdersApiPresenterLayer.OrdersApiPresenter;

public class CreateProcessor implements IOrderCreation {

    IOrderCreation next;

    @Override
    public Action Handle(IAction action) {
        switch (action.GetAction()) {
            case ActionEnum.SetWorker -> {
                System.out.println("Success set worker\n");
                setNext(new UpdateProcessor());
                return new Action(ActionEnum.SetClient);
            }
            case ActionEnum.SetClient -> {
                System.out.println("Success set client\n");
                setNext(new UpdateProcessor());
                return new Action(ActionEnum.SetDevice);
            }
            case ActionEnum.SetDevice -> {
                System.out.println("Success set device\n");
                setNext(new UpdateProcessor());
                return new Action(ActionEnum.Insert);
            }
            default -> {
                setNext(new CreateProcessor());
                return new Action(ActionEnum.Insert);
            }
        }
    }

    @Override
    public void setNext(IOrderCreation next) {
        this.next = next;
    }
}