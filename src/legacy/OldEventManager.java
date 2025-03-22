package legacy;

import java.util.ArrayList;

public class OldEventManager {
    private ArrayList<OldEvent> events;
    private OldSaveFileManager fileManager;

    public OldEventManager(OldSaveFileManager fileManager) {
        this.fileManager = fileManager;

        events = new ArrayList<>();
        loadEvents();
    }

    public void loadEvents() {
        events = fileManager.getEvents();
    }

    public void saveEvents() {
        for (OldEvent event : events) {
            fileManager.saveEvent(event);
        }
    }

    public void addEvent(OldEvent event) {
        events.add(event);
    }

    public ArrayList<OldEvent> getEvents() {
        return events;
    }
}
