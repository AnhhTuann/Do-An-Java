import java.nio.file.Paths;
import java.util.Scanner;

public class Shop
{
    /*Constructor*/
    public Shop()
    {
        publisherList = new PublisherList();
        gameList = new GameList(publisherList);
        cardList = new CardList(publisherList);
        stateMachine = new StateMachine<Shop>(this);
        stateMachine.setCurrentState(MainMenuState.getInstance());
        stateMachine.changeState(MainMenuState.getInstance());
        isExit = false;
    }
    
    /*Members*/
    PublisherList publisherList;
    GameList gameList;
    CardList cardList;
    StateMachine<Shop> stateMachine;
    boolean isExit;

    public static Scanner scanner = new Scanner(System.in);

    /*Get methods*/
    public GameList getGameList() { return gameList; }
    public CardList getCardList() { return cardList; }
    public PublisherList getPublisherList() { return publisherList; }
    public StateMachine<Shop> getStateMachine() { return stateMachine; }

    /*Set methods*/
        
    /*Other methods*/
    public void update()
    {
        stateMachine.update();
    }

    public void exit() { isExit = true; }

    public boolean isExit() { return isExit; }

    /*Main method*/
    public static void main(String[] args)
    {
        Shop shop = new Shop();

        while(!shop.isExit())
        {
            shop.update();
        }

        scanner.close();
    }
}