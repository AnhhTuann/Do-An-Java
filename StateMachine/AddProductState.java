public class AddProductState implements State<Shop>
{
    /*Constructor*/
    private AddProductState() {}
    /*Members*/
    private static AddProductState instance;

    /*Get methods*/
    public static AddProductState getInstance() {
        if (instance == null)
        {
            instance = new AddProductState();
        }

        return instance;
    }

    /*Other methods*/
    @Override
    public void enter(Shop owner) {
        System.out.print("\n--Which type of product do you want to add?\n1. Game\n2. Card\n3. Cancel\nInput: ");
    }

    @Override
    public void execute(Shop owner) {
        switch (Shop.scanner.nextInt())
        {
            case 1:
            {
                Shop.scanner.nextLine();
                System.out.print("\nGame chosen! Input ID: ");
                String id = Shop.scanner.nextLine();
                System.out.print("How many products do you want to add? ");
                int quantity = Shop.scanner.nextInt();
                Shop.scanner.nextLine();
                owner.getGameList().addProduct(id, quantity, Game.class);
                owner.getStateMachine().changeState(this);
                break;
            }
            case 2:
            {
                Shop.scanner.nextLine();
                System.out.print("\nCard chosen! Input ID: ");
                String id = Shop.scanner.nextLine();
                System.out.print("How many products do you want to add? ");
                int quantity = Shop.scanner.nextInt();
                Shop.scanner.nextLine();
                owner.getCardList().addProduct(id, quantity, Card.class);
                owner.getStateMachine().changeState(this);
                break;
            }
            case 3:
                owner.getStateMachine().changeState(StaffMenuState.getInstance());;
                break;
            default: 
                System.out.print("Invalid option! Please input: ");
                break;
        }
    }
    
    @Override
    public void exit(Shop owner) {}
}