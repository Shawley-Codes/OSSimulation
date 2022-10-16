public class Kernal {

    //the main method to run the kernel simulation
    public static void main(String[] args) {
        try {
            ProcessManager.main();
            Thread.sleep(41000);
            InterProcessCommunication.main();
            Thread.sleep(15000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Network client = new Network("whois.internic.net", 43, "google.com");
        Network client2 = new Network("google.com", 80);

        FileManager fileManager = new FileManager();
        fileManager.create("hello.txt", "OsSimulation/hello.txt");

        StorageController storageController = new StorageController();

        for (int i = 0; i < 5; i++) {
            storageController.addSecondaryStorage(new Object());
        }


        Object memoryObject = storageController.getSecondaryStorage(0);
        Object memoryObject1 = storageController.getSecondaryStorage(1);
        Object memoryObject2 = storageController.getSecondaryStorage(2);
        Object memoryObject3 = storageController.getSecondaryStorage(3);


        storageController.setSecondaryStorage(0, memoryObject);
        storageController.setSecondaryStorage(1, memoryObject1);
        storageController.setSecondaryStorage(2, memoryObject2);
        storageController.setSecondaryStorage(3, memoryObject3);

    }

}
