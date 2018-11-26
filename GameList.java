import java.util.LinkedList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.lang.NoSuchMethodException;
import java.lang.SecurityException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.IllegalArgumentException;
import java.lang.reflect.InvocationTargetException;

public class GameList extends ProductList<Game>
{
    /*Constructor*/
    public GameList(PublisherList publisherList) throws NoSuchMethodException, 
                                                        SecurityException, 
                                                        InstantiationException,
                                                        IllegalAccessException,
                                                        IllegalArgumentException,
                                                        InvocationTargetException 
    {
        path = ".\\data\\gamelist.bin";

        list = new LinkedList<Game>();
        this.publisherList = publisherList;

        FileIO.readFromFile(list, path, Game.class);
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
            FileIO.writeToFile(newProduct, path);
            for (int i = 0; i < quantity - 1; ++i)
            {
                Game product = new Game(newProduct);
                list.add(product);
                FileIO.writeToFile(product, path);
            }
        }
        else
        {
            Game existProduct = getProduct(id);
            for (int i = 0; i < quantity; ++i)
            {
                Game product = new Game(existProduct);
                list.add(product);
                FileIO.writeToFile(product, path);
            }
        }
    }

    @Override
    public String toString(){
        String str;
        str = "\n**Game List**\n--------------------\n";
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