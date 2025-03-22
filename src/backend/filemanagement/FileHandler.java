package backend.filemanagement;

import backend.outreach.Outreach;

import java.io.*;
import java.util.ArrayList;

/**
 * Manages the saving and loading of events to file
 */
public class FileHandler {
    private String fileName;

    /**
     * Creates a new file manager
     * @param filename the save file location
     */
    public FileHandler(String filename) {
        this.fileName = filename;
    }

    /**
     * Saves the outreach
     * @param outreaches list of outreach to save
     */
    public void saveOutreach(ArrayList<Outreach> outreaches) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(outreaches);
            System.out.println("Outreach list saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving outreach list: " + e.getMessage());
        }
    }

    /**
     * Loads outreach from file
     * @return ArrayList of outreach
     */
    public ArrayList<Outreach> loadOutreachList() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<Outreach>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading outreach list: " + e.getMessage());
            return null;
        }
    }
}
