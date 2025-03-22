package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

public class Event extends Outreach implements Serializable {

    protected double duration;
    protected int difficulty;
    protected int participatingTeams;

    /**
     * Default constructor.
     */
    public Event() {
        this.duration = 0;
        this.difficulty = 1;
        this.participatingTeams = 0;
    }

    /**
     * Initializes the outreach object
     * @param title event title
     * @param summary event summary
     * @param date event date
     * @param duration duration of the event in hours
     * @param difficulty difficulty level of the event (1 or 2)
     * @param participatingTeams number of teams that participated
     */
    public Event(String title, String summary, LocalDate date, double duration, int difficulty, int participatingTeams) {
        super(title, summary, date);
        this.duration = duration;
        this.difficulty = difficulty;
        this.participatingTeams = participatingTeams;
    }

    /**
     * Get the length of the event in hours
     * @return number of hours that the event lasted
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Updates the duration (in hours) of the event
     * @param duration new duration (hours)
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Gets the difficulty of the event (1 or 2)
     * @return event difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Updates the difficulty of the event (1 or 2)
     * @param difficulty new difficulty value
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the number of participating teams
     * @return
     */
    public int getParticipatingTeams() {
        return participatingTeams;
    }

    /**
     * Updates the number of participating teams
     * @param participatingTeams
     */
    public void setParticipatingTeams(int participatingTeams) {
        this.participatingTeams = participatingTeams;
    }


    /**
     * Gives a string of the outreach details
     * @return all the details listed as a string with new lines
     */
    public String toString() {
        return title + "\n" +
                date.toString() + "\n" +
                summary + "\n" +
                duration + "\n" +
                difficulty + "\n" +
                participatingTeams;
    }
}
