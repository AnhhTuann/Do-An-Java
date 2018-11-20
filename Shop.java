import java.util.Scanner;
public class Shop
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductList<Game> list = new ProductList<Game>();

        list.addProduct("001", 1);
        list.addProduct("002", 1);
        list.addProduct("001", 1);

        System.out.print(list.toString());

        scanner.close();
    }
}