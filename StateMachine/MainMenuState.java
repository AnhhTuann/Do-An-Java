public class MainMenuState implements State<Shop>
{
    /*Constructor - Singleton*/
    private MainMenuState() {}
    
    /*Members*/
    private static MainMenuState instance;

    /*Get methods*/
    public static MainMenuState getInstance() {
        if (instance == null)
        {
            instance = new MainMenuState();
        }

        return instance;
    }

    /*Other methods*/
    @Override
    public void enter(Shop owner) {
        System.out.print("\n+++++ WELCOME TO OUR SHOP +++++\n");
        System.out.print("\n=== Choose the option ===\n1. Customer\n2. Staff\n3. Exit\nInput: ");
    }

    @Override
    public void execute(Shop owner) {
        switch(Shop.scanner.nextInt())
        {
            case 1:
                break;
            case 2:
                owner.getStateMachine().changeState(StaffMenuState.getInstance());
                break;
            case 3:
                System.out.println("\nGOODBYE!");
                owner.exit();
                break;
            default:
                System.out.print("Invalid option! Please input: ");
                break;
        }
    }

    @Override
    public void exit(Shop owner) {
        owner.getStateMachine().setPreviousState(this);
    }
}