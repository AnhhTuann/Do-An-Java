import java.util.Scanner;
public class Shop
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameList gameList = new GameList();
        CardList cardList = new CardList();

        gameList.addProduct("001", 1);
        gameList.addProduct("002", 1);
        gameList.addProduct("001", 1);
        cardList.addProduct("005", 1);
        cardList.addProduct("005", 3);

        System.out.print(gameList.toString());
        System.out.print(cardList.toString());

        scanner.close();
    }
}