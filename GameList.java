import java.util.LinkedList;
import java.io.IOException;
import java.nio.file.*;

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
            writeToFile(newProduct);
            for (int i = 0; i < quantity - 1; ++i)
            {
                Game product = new Game(newProduct);
                list.add(product);
                writeToFile(product);
            }
        }
        else
        {
            Game existProduct = getProduct(id);
            for (int i = 0; i < quantity; ++i)
            {
                Game product = new Game(existProduct);
                list.add(product);
                writeToFile(product);
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

    @Override
    public void writeToFile(Game product) {
        String path = ".\\data\\gamelist.bin";
        IFileIO.checkFileExist(path);

        String str = product.getID() + " " 
                   + product.getName() + " " 
                   + product.getPublisher() + " " 
                   + product.getPrice() + " " 
                   + product.getReleasedYear() + " "
                   + product.getGenre().toString() + " "
                   + product.getPlatform().toString() + " " 
                   + product.getVersion() + " "
                   + product.getCode()
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

    @Override
    public void readFromFile() {
        String path = ".\\data\\gamelist.bin";
        IFileIO.checkFileExist(path);
        
        try {
            byte[] data = Files.readAllBytes(Paths.get(path));
            String str = new String(data);
            String[] info = str.split("xDATASEPARATEx");
        
            for (String s : info)
            {
                String[] details = s.split(" ");
                Game game = new Game();
                game.setID(details[0]);
                game.setName(details[1]);
                game.setPublisher(details[2]);
                game.setPrice(Integer.parseInt(details[3]));
                game.setReleasedYear(Integer.parseInt(details[4]));
                game.setGenre(Game.Genre.valueOf(details[5]));
                game.setPlatform(Game.Platform.valueOf(details[6]));
                game.setVersion(details[7]);
                game.setCode(details[8]);
                list.add(game);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}