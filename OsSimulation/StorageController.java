import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StorageController {
    private List<Object> secondaryStorage = new ArrayList<>(1000);

    public StorageController() {}

    public void setSecondaryStorage(int index, Object obj) {
        secondaryStorage.set(index, obj);
    }

    public void addSecondaryStorage(Object obj) {
        secondaryStorage.add(obj);
    }

    public Object getSecondaryStorage(int index) {
        return secondaryStorage.get(index);
    }
}
