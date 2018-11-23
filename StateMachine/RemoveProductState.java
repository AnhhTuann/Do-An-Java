public class RemoveProductState implements State<Shop>
{
    /*Constructor - Singleton*/
    private RemoveProductState() {}
    
    /*Members*/
    private static RemoveProductState instance;

    /*Get methods*/
    public static RemoveProductState getInstance() {
        if (instance == null)
        {
            instance = new RemoveProductState();
        }

        return instance;
    }

    /*Other methods*/
    @Override
    public void enter(Shop owner) {
        System.out.print("\n--Which type of product do you want to remove?\n1. Game\n2. Card\n3. Cancel\nInput: ");
    }

    @Override
    public void execute(Shop owner) {
        switch (Shop.scanner.nextInt())
        {
            case 1:
            {
                removeProduct(owner.getGameList());
                owner.getStateMachine().changeState(this);
                break;
            }
            case 2:
            {
                removeProduct(owner.getCardList());
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

    private void removeProduct(ProductList list) {
        Shop.scanner.nextLine();
        if (list.getClass().getName().equalsIgnoreCase("GameList"))
        {
            System.out.print("\nGame chosen! Input ID: ");
        }
        else
        {
            System.out.print("\nCard chosen! Input ID: ");
        }
        String id = Shop.scanner.nextLine();
        System.out.print("How many products do you want to remove (type 'all' to remove all products)? ");
        String quantity = Shop.scanner.nextLine();
        if (quantity.equalsIgnoreCase("all"))
        {
            list.removeAllProduct(id);
        }
        else
        {
            list.removeProduct(id, Integer.parseInt(quantity));
        }
    }
}