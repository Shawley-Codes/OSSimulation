public class FileData {
        //this is a dataclass to store information about files
        //file type, date modified and created, size and the directory
        String filename;
        String filetype;
        int Index;
        short filesize;
        String directoryURL;
        String mode;

        FileData(String filename, String filetype, String mode){
            this.filename = filename;
            this.filetype = filetype;
            this.mode = mode;
        }
}
