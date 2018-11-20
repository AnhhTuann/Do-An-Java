import java.util.LinkedList;

public class GameList extends ProductList<Game>
{
    /*Constructor*/
    public GameList() {
        list = new LinkedList<Game>();
    }
    /*Other methods*/
    @Override
    public void addProduct(String id, int quantity) {
        int index = findProduct(id);
        if (index == -1)
        {
            System.out.println("This is new ID!");
            Game newProduct = new Game(id);
            list.add(newProduct);
            for (int i = 0; i < quantity - 1; ++i)
            {
                Game product = new Game(newProduct);
                list.add(product);
            }
        }
        else
        {
            Game existProduct = getProduct(id);
            for (int i = 0; i < quantity; ++i)
            {
                Game product = new Game(existProduct);
                list.add(product);
            }
        }
    }
}