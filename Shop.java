import java.util.Scanner;
public class Shop
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game("001");
        Card card = new Card("002");
        System.out.println(game.toString());
        System.out.print(card.toString());
        scanner.close();
    }
}