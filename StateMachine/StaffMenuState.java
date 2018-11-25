public class StaffMenuState implements State<Shop>
{
    /*Constructor - Singleton*/
    private StaffMenuState() {}

    /*Members*/
    private static StaffMenuState instance;

    /*Get methods*/
    public static StaffMenuState getInstance() {
        if (instance == null)
        {
            instance = new StaffMenuState();
        }
        
        return instance;
    }

    /*Other methods*/
    @Override
    public void enter(Shop owner) {
        System.out.print("\n=== Choose the option ===\n1. Add product\n2. Remove Product\n3. View list\n4. View Product" +
                         "\n5. Get Quantity\n6. Get Total Quantity\n7. Logout\nInput: ");
    }

    @Override
    public void execute(Shop owner) {
        switch(Shop.scanner.nextInt())
        {
            case 1:
                owner.getStateMachine().changeState(AddProductState.getInstance());
                break;
            case 2:
                owner.getStateMachine().changeState(RemoveProductState.getInstance());
                break;
            case 3:
                owner.getStateMachine().changeState(ViewListState.getInstance());
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                owner.getStateMachine().revertToPreviousState();;
                break;
            default:
                System.out.print("Invalid option! Please input: ");
                break;
        }
    }

    @Override
    public void exit(Shop owner) {}
}