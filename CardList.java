import java.io.IOException;
import java.util.LinkedList;

public class CardList extends ProductList<Card>
{
    /*Constructor*/
    public CardList(PublisherList publisherList)
    {
        path = ".\\data\\cardlist.bin";

        list = new LinkedList<Card>();
        this.publisherList = publisherList;

        FileIO.readFromFile(list, path, Card.class);
    }

    /*Other methods*/
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