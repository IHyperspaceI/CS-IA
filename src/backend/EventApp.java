package backend;

import java.time.LocalDate;

public class EventApp {
    public static void main(String[] args) {
        SaveFileManager fileManager = new SaveFileManager("saved.json");
        EventManager manager = new EventManager(fileManager);

        Event event = new Event(fileManager.getNumEvents(), "test", "testing", LocalDate.now(), 0);

        manager.loadEvents();
        manager.addEvent(event);
        manager.saveEvents();
    }
}
