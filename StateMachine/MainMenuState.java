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
    public void enter(Shop owner) {
        System.out.print("\n+++++ WELCOME TO OUR SHOP +++++\n");
        System.out.print("\n=== Choose the option ===\n1. Customer\n2. Staff\nInput: ");
    }

    public void execute(Shop owner) {
        switch(owner.scanner.nextInt())
        {
            case 1:
                
            case 2:
            case 3:
        }
    }
}