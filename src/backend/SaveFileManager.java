package backend;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

public class SaveFileManager {
    private String fileName;
    private Gson gson;
    private int numEvents;

    public SaveFileManager(String fileName) {
        this.fileName = fileName;
        gson = new Gson();
        numEvents = loadEvents().size();
    }

    public int getNumEvents() {
        return numEvents;
    }

    public void saveEvent(Event event) {
        JsonArray eventsJson = loadEvents();
        boolean eventUpdated = false;

        for (int i = 0; i < eventsJson.size(); i++) {
            JsonArray array = eventsJson.get(i).getAsJsonArray();
            if (array.get(0).getAsInt() == event.getId()) {
                // Update the existing event
                JsonObject eventJson = createEventJson(event);
                array.set(1, eventJson);
                eventUpdated = true;
                break;
            }
        }

        if (!eventUpdated) {
            JsonObject eventJson = createEventJson(event);
            JsonArray eventArray = new JsonArray();
            eventArray.add(event.getId());
            eventArray.add(eventJson);
            eventsJson.add(eventArray);
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            gson.toJson(eventsJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JsonObject createEventJson(Event event) {
        JsonObject eventJson = new JsonObject();
        eventJson.addProperty("name", event.getName());
        eventJson.addProperty("summary", event.getSummary());
        eventJson.addProperty("duration", event.getDuration());
        eventJson.addProperty("date_day", event.getDate().getDayOfMonth());
        eventJson.addProperty("date_month", event.getDate().getMonthValue());
        eventJson.addProperty("date_year", event.getDate().getYear());
        eventJson.addProperty("people_reached", event.getPeopleReached());
        eventJson.addProperty("difficulty", event.getDifficulty());
        eventJson.addProperty("first_definition", event.getFirstDefinition());
        eventJson.addProperty("photos_link", event.getPhotosLink());
        return eventJson;
    }

    public ArrayList<Event> getEvents() {
        ArrayList<Event> eventList = new ArrayList<>();
        JsonArray eventsJson = loadEvents();

        for (int i = 0; i < eventsJson.size(); i++) {
            JsonArray eventArray = eventsJson.get(i).getAsJsonArray();
            int eventId = eventArray.get(0).getAsInt();
            JsonObject eventJson = eventArray.get(1).getAsJsonObject();

            int day = eventJson.get("date_day").getAsInt();
            int month = eventJson.get("date_month").getAsInt();
            int year = eventJson.get("date_year").getAsInt();

            Event event = new Event(eventId, eventJson.get("name").getAsString(), eventJson.get("summary").getAsString(), LocalDate.of(year, month, day), eventJson.get("duration").getAsInt());
            event.setPeopleReached(eventJson.get("people_reached").getAsInt());
            event.setDifficulty(eventJson.get("difficulty").getAsInt());
            event.setFirstDefinition(eventJson.get("first_definition").getAsString());
            event.setPhotosLink(eventJson.get("photos_link").getAsString());
            eventList.add(event);
        }

        return eventList;
    }

    public JsonArray loadEvents() {
        try {
            JsonParser parser = new JsonParser();
            return parser.parse(Files.readString(FileSystems.getDefault().getPath(fileName))).getAsJsonArray();
        } catch (Exception e) {
            return new JsonArray();
        }
    }
}
