import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.lang.NoSuchMethodException;
import java.lang.SecurityException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.IllegalArgumentException;
import java.lang.reflect.InvocationTargetException;

public class FileIO
{
    public static <T extends IWritable> void writeToFile(T object, String path) {
        checkFileExist(path);
        String str = object.toData();
        byte[] data = str.getBytes();

        try {
            Files.write(Paths.get(path), data, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static <T extends IWritable> void rewriteFile(LinkedList<T> list, String path) {
        try {
            Files.delete(Paths.get(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        for (T product : list)
        {
            writeToFile(product, path);
        }
    }

    public static <T extends IWritable> void readFromFile(LinkedList<T> list, String path, Class<T> tclass)
    {
        checkFileExist(path);
        
        try {
            byte[] data = Files.readAllBytes(Paths.get(path));
            String str = new String(data);
            String[] info = str.split("xDATASEPARATEx");
        
            for (String s : info)
            {
                String[] details = s.split(" ");
                try
                {
                    T object = (T)tclass.getDeclaredConstructor().newInstance();
                    object.getData(details);
                    list.add(object);
                }
                catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException |InvocationTargetException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkFileExist(String path) {
        if (!Files.exists(Paths.get(path)))
        {
            try {
                Files.createFile(Paths.get(path));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}