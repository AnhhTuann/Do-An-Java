import java.io.IOException;
import java.util.LinkedList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.lang.NoSuchMethodException;
import java.lang.SecurityException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.IllegalArgumentException;
import java.lang.reflect.InvocationTargetException;

public class CardList extends ProductList<Card>
{
    /*Constructor*/
    public CardList(PublisherList publisherList) throws NoSuchMethodException, 
                                                        SecurityException, 
                                                        InstantiationException,
                                                        IllegalAccessException,
                                                        IllegalArgumentException,
                                                        InvocationTargetException 
    {
        path = ".\\data\\cardlist.bin";

        list = new LinkedList<Card>();
        this.publisherList = publisherList;

        FileIO.readFromFile(list, path, Card.class);
    }

    /*Other methods*/
    @Override
    public void addProduct(String id, int quantity) {
        int index = findProduct(id);
        if (index == -1)
        {
            System.out.println("This is new ID!");
            Card newProduct = new Card(id);

            if (!checkPublisherList(newProduct))
            {
                System.out.println("Failed! Invalid information!");
                return;
            }
            
            list.add(newProduct);
            FileIO.writeToFile(newProduct, path);
            for (int i = 0; i < quantity - 1; ++i)
            {
                Card product = new Card(newProduct);
                list.add(product);
                FileIO.writeToFile(product, path);
            }
        }
        else
        {
            Card existProduct = getProduct(id);
            for (int i = 0; i < quantity; ++i)
            {
                Card product = new Card(existProduct);
                list.add(product);
                FileIO.writeToFile(product, path);
            }
        }
    }

    @Override
    public String toString(){
        String str;
        str = "\n**Card List**\n--------------------\n";
        str += String.format("|%-10s|%-20s|%-20s|%-5s|%-10s|%-20s|%-10s|", 
                             "ID", "Name", "Publisher", "Type", "Price", "Serial number", "Value");
        str += "\n--------------------\n";
        for (Card product : list)
        {
            str += product.toString();
        }

        return str;
    }
}