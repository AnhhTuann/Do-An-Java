import java.io.IOException;
import java.util.LinkedList;
import java.nio.file.*;

public class CardList extends ProductList<Card>
{
    /*Constructor*/
    public CardList(PublisherList publisherList) {
        list = new LinkedList<Card>();
        this.publisherList = publisherList;
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
            writeToFile(newProduct);
            for (int i = 0; i < quantity - 1; ++i)
            {
                Card product = new Card(newProduct);
                list.add(product);
                writeToFile(product);
            }
        }
        else
        {
            Card existProduct = getProduct(id);
            for (int i = 0; i < quantity; ++i)
            {
                Card product = new Card(existProduct);
                list.add(product);
                writeToFile(product);
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

    @Override
    public void writeToFile(Card product) {
        String path = ".\\data\\cardlist.bin";

        IFileIO.checkFileExist(path);

        String str = product.getID() + " " 
                   + product.getName() + " " 
                   + product.getPublisher() + " " 
                   + product.getPrice() + " " 
                   + product.getSerialNumber() + " "
                   + product.getValue()
                   + "xDATASEPARATEx";

        byte[] data = str.getBytes();
        System.out.println(data);

        try {
            Files.write(Paths.get(path), data, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}