package DataManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFileManager {
    private static final String DATA_FILE = "data.dat";

    public static void saveData(List<Object> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Object> loadData() {
        List<Object> data = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            data = (List<Object>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void updateData(Object newData) {
        List<Object> existingData = loadData();
        existingData.add(newData);
        saveData(existingData);
    }

    public static void deleteData(Object dataToDelete) {
        List<Object> existingData = loadData();
        existingData.remove(dataToDelete);
        saveData(existingData);
    }
}

