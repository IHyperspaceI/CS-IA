package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Contains information for an event that was supported by the team
 */
public class SupportedEvent extends Event implements Serializable {
    private String hostTeam;

    /**
     * Default constructor
     */
    public SupportedEvent() {
        this.hostTeam = "";
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
    public SupportedEvent(String title, String summary, LocalDate date, double duration, int difficulty, int participatingTeams, String hostTeam) {
        super(title, summary, date, duration, difficulty, participatingTeams);
        this.hostTeam = hostTeam;
    }

    public String getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(String hostTeam) {
        this.hostTeam = hostTeam;
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
                participatingTeams + "\n" +
                hostTeam;
    }
}
