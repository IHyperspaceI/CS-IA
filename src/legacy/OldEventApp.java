package legacy;

import java.time.LocalDate;

public class OldEventApp {
    public static void main(String[] args) {
        OldSaveFileManager fileManager = new OldSaveFileManager("saved.json");
        OldEventManager manager = new OldEventManager(fileManager);

        OldEvent event = new OldEvent(fileManager.getNumEvents(), "test", "testing", LocalDate.now(), 0);

        manager.loadEvents();
        manager.addEvent(event);
        manager.saveEvents();
    }
}
