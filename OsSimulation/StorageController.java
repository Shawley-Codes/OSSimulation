import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StorageController {
    private List<Object> secondaryStorage = new ArrayList<>(1000);

    public StorageController() {}

    public void setSecondaryStorage(int index, Object obj) {
        System.out.println("Writing to secondary memory block " + obj);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondaryStorage.set(index, obj);
    }

    public void addSecondaryStorage(Object obj) {
        System.out.println("Saving Obj: " + obj);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondaryStorage.add(obj);
    }

    public Object getSecondaryStorage(int index) {
        System.out.println("Getting Obj: " + secondaryStorage.get(index));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return secondaryStorage.get(index);
    }
}
