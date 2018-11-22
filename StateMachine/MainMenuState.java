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

    }
}