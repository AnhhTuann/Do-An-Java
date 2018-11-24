public class ViewListState implements State<Shop>
{
    /*Constructor - Singleton*/
    private ViewListState() {}
    
    /*Members*/
    private static ViewListState instance;

    /*Get methods*/
    public static ViewListState getInstance() {
        if (instance == null)
        {
            instance = new ViewListState();
        }

        return instance;
    }

    /*Other methods*/
    @Override
    public void enter(Shop owner) {
        System.out.print("\n--Which type of list do you want to view?\n1. Game List\n2. Card List\n3. Cancel\nInput: ");
    }

    @Override
    public void execute(Shop owner) {
        switch(Shop.scanner.nextInt())
        {
            case 1:
            {
                System.out.print("\n" + owner.getGameList().toString());
                enter(owner);
                break;
            }
            case 2:
            {
                System.out.print("\n" + owner.getCardList().toString());
                enter(owner);
                break;
            }
            case 3:
                owner.getStateMachine().changeState(StaffMenuState.getInstance());
                break;
            default:
                System.out.print("Invalid option! Please input: ");
                break;
        }
    }

    @Override
    public void exit(Shop owner) {}
}