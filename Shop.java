import java.util.Scanner;
public class Shop
{
    /*Constructor*/
    public Shop() {
        publisherList = new PublisherList();
        gameList = new GameList(publisherList);
        cardList = new CardList(publisherList);
    }
    
    /*Members*/
    PublisherList publisherList;
    GameList gameList;
    CardList cardList;

    public static Scanner scanner = new Scanner(System.in);

    /*Get methods*/
    /*Set methods*/
    /*Main method*/
    public static void main(String[] args) {

        gameList.addProduct("001", 1);
        gameList.addProduct("002", 1);
        gameList.addProduct("001", 1);
        cardList.addProduct("005", 1);
        cardList.addProduct("005", 3);

        System.out.print(gameList.toString());
        System.out.print(cardList.toString());

        scanner.close();
    }
    
    /*Other methods*/
}