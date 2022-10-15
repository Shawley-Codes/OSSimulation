import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManager {
        //simulate methods for creating, storing and opening files
    RandomAccessFile file;
    FileData data;

    FileManager(String filename, String filetype, String mode) throws IOException {
        data = new FileData(filename, filetype, mode);
        open();
    }
    void create(){


    }

    void open() throws IOException {
        file = new RandomAccessFile( data.filename , data.mode );
        read(file);

    }

    void close() throws IOException {
        if(file != null)
            file.close();
    }

    void read(RandomAccessFile file) throws IOException {
        data.filesize = file.readShort();
    }

    void write(byte[] bytes) throws IOException {

    }

    int getFileSize(){

        return 0;
    }

}
