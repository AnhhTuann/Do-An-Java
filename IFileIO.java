import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

public interface IFileIO<T>
{
    public void writeToFile(T product);
    public void readFromFile();
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