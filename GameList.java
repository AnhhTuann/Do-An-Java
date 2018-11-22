import java.util.LinkedList;

public class GameList extends ProductList<Game>
{
    /*Constructor*/
    public GameList(PublisherList publisherList) {
        list = new LinkedList<Game>();
        this.publisherList = publisherList;
    }
    /*Other methods*/
    @Override
    public void addProduct(String id, int quantity) {
        int index = findProduct(id);
        if (index == -1)
        {
            System.out.println("This is new ID!");
            Game newProduct = new Game(id);

            if (!checkPublisherList(newProduct))
            {
                System.out.println("Failed! Invalid information!");
                return;
            }

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

    @Override
    public String toString(){
        String str = new String("");
        str += "\n**Game List**\n--------------------\n";
        str += String.format("|%-10s|%-20s|%-20s|%-5s|%-10s|%-5s|%-20s|%-10s|%-10s|",  
                             "ID", "Name", "Publisher", "Type", "Price", "Year", "Genre", "Platform", "Version");
        str += "\n--------------------\n";
        for (Game product : list)
        {
            str += product.toString();
        }

        return str;
    }
}