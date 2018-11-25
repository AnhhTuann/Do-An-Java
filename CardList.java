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
                   + product.getValue() + " "
                   + product.getCode()
                   + "xDATASEPARATEx";

        byte[] data = str.getBytes();

        try {
            Files.write(Paths.get(path), data, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rewriteFile() {
        String path = ".\\data\\cardlist.bin";

        try {
            Files.delete(Paths.get(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        for (Card product : list)
        {
            writeToFile(product);
        }
    }

    @Override
    public void readFromFile() {
        String path = ".\\data\\cardlist.bin";
        IFileIO.checkFileExist(path);
        
        try {
            byte[] data = Files.readAllBytes(Paths.get(path));
            String str = new String(data);
            String[] info = str.split("xDATASEPARATEx");
        
            for (String s : info)
            {
                String[] details = s.split(" ");
                Card card = new Card();
                card.setID(details[0]);
                card.setName(details[1]);
                card.setPublisher(details[2]);
                card.setPrice(Integer.parseInt(details[3]));
                card.setSerialNumber(details[4]);
                card.setValue(Integer.parseInt(details[5]));
                card.setCode(details[6]);
                list.add(card);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}