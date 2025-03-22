package backend;

import backend.outreach.Outreach;
import java.util.ArrayList;

/**
 * Manages a list of Outreach objects, including searching for titles
 */
public class OutreachManager {
    ArrayList<Outreach> outreaches;

    /**
     * New manager
     */
    public OutreachManager() {
        outreaches = new ArrayList<>();
    }

    /**
     * New manager with a predefined list
     * @param outreaches already existing list of outreach
     */
    public OutreachManager(ArrayList<Outreach> outreaches) {
        if (outreaches != null) {
            this.outreaches = outreaches;
        } else {
            this.outreaches = new ArrayList<>();
        }
    }

    /**
     * Adds an outreach to the manager
     * @param outreach outreach to add
     */
    public void addOutreach(Outreach outreach) {
        outreaches.add(outreach);
        outreaches.sort(Outreach::compareTo);
    }

    /**
     * Removes an outreach from the manager
     * @param outreach the outreach to delete
     */
    public void removeOutreach(Outreach outreach) {
        outreaches.remove(outreach);
    }

    /**
     * Gets an ArrayList of all the outreach
     * @return outreach list
     */
    public ArrayList<Outreach> getAll() {
        return outreaches;
    }

    /**
     * Returns a list of all the outreaches and their index
     * @return list of outreach
     */
    public String showAll() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < outreaches.size(); i++) {
            builder.append("\n").append(i).append(": ").append(outreaches.get(i).getTitle());
        }

        return builder.toString();
    }

    /**
     * Returns the outreach instance for the title, or null if it doesn't exist
     * @param title title to search for
     * @return outreach object
     */
    public Outreach getOutreach(String title) {
        for (Outreach outreach : outreaches) {
            if (outreach.getTitle().equals(title)) {
                return outreach;
            }
        }
        return null;
    }

    /**
     * Returns the outreach instance for the given index, or null if out of bounds
     * @param index index to call
     * @return outreach object
     */
    public Outreach getOutreach(int index) {
        if (index >= outreaches.size()) { return null; }

        return outreaches.get(index);
    }
}
