import java.util.LinkedList;
import java.io.IOException;

public class GameList extends ProductList<Game>
{
    /*Constructor*/
    public GameList(PublisherList publisherList)
    {
        path = ".\\data\\gamelist.bin";

        list = new LinkedList<Game>();
        this.publisherList = publisherList;

        FileIO.readFromFile(list, path, Game.class);
    }

    /*Other methods*/
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