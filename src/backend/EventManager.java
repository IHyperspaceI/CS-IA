package backend;

import java.util.ArrayList;

public class EventManager {
    private ArrayList<Event> events;
    private SaveFileManager fileManager;

    public EventManager(SaveFileManager fileManager) {
        this.fileManager = fileManager;

        events = new ArrayList<>();
        loadEvents();
    }

    public void loadEvents() {
        events = fileManager.getEvents();
    }

    public void saveEvents() {
        for (Event event : events) {
            fileManager.saveEvent(event);
        }
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
}
