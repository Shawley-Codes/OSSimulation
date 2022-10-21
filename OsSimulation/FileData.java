import java.io.File;
import java.time.LocalDateTime;

public class FileData {
        //this is a dataclass to store information about files
        //file type, date modified and created, size and the directory
        private File actFile;
        private String filename;
        private LocalDateTime dateCreated;
        private LocalDateTime dateModified;
        private int Index;
        //short filesize;
        private String directoryURL;


        public FileData(File file, String filename, String directoryURL, int index){
            actFile = file;
            this.filename = filename;
            this.directoryURL = directoryURL;
            dateCreated = LocalDateTime.now();
            dateModified = LocalDateTime.now();
            Index = index;
        }

        public void printData(){
            System.out.println("FileName: " + filename);
            System.out.println("Created: " + dateCreated);
            System.out.println("Last Modified: " + dateModified);
            System.out.println("Directory: " + directoryURL);
        }

        public void setDateModified(){
            dateModified = LocalDateTime.now();
        }
}
