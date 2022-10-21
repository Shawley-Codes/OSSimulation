import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
        //simulate methods for creating, storing and opening files
    private RandomAccessFile file;
    private FileData data;
    private List<FileData> files = new ArrayList<FileData>();
    private int Index = files.size();

    public FileManager() {
        System.out.println("\nCreated File Manager\n");
    }
    public void create(String filename, String fileurl){
        File obj = new File("myfile.txt");
        try {
            if (obj.createNewFile()) {
                System.out.println("File created: " + obj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        Index = files.size();
        data = new FileData(obj, filename, fileurl, Index);
        files.add(Index, data);

        files.get(Index).printData();
    }
}
