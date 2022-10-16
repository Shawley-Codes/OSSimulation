import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
        //simulate methods for creating, storing and opening files
    RandomAccessFile file;
    FileData data;
    List<FileData> files = new ArrayList<FileData>();
    int Index = files.size();

    FileManager() {
        System.out.println("\nCreated File Manager\n");
    }
    void create(String filename, String fileurl){
        File obj = new File("myfile.txt");
        Index = files.size();
        data = new FileData(obj, filename, fileurl, Index);
        files.add(Index, data);

        files.get(Index).printData();
    }

    void open() {

    }

    void close() {

    }

}
