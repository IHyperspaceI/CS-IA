package legacy;

import java.time.LocalDate;

public class OldEvent {
    private int id;
    private String name;
    private String summary;
    private LocalDate date;
    private double duration;
    private int peopleReached;
    private int difficulty;
    private String firstDefinition;
    private String photosLink;

    public OldEvent(int id, String name, String summary, LocalDate date, double duration) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.date = date;
        this.duration = duration;
        this.firstDefinition = "";
        this.photosLink = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getPeopleReached() {
        return peopleReached;
    }

    public void setPeopleReached(int peopleReached) {
        this.peopleReached = peopleReached;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getFirstDefinition() {
        return firstDefinition;
    }

    public void setFirstDefinition(String firstDefinition) {
        this.firstDefinition = firstDefinition;
    }

    public String getPhotosLink() {
        return photosLink;
    }

    public void setPhotosLink(String photosLink) {
        this.photosLink = photosLink;
    }

    public int getId() {
        return id;
    }

    public String toJson() {
        return String.format("""
                    "%d": {
                        "name": "%s",
                        "summary": "%s",
                        "date": [
                            %d,
                            %d,
                            %d
                        ],
                        "duration": %f,
                        "people_reached": %d,
                        "difficulty": %d,
                        "first_definition": "%s",
                        "photos_link": "%s"
                    },
                """, id, name, summary, date.getDayOfMonth(), date.getMonthValue(), date.getYear(), duration, peopleReached, difficulty, firstDefinition, photosLink);
    }
}