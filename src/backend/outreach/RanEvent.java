package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Contains information for an event that was ran by the team
 */
public class RanEvent extends Event implements Serializable {
    /**
     * Default constructor
     */
    public RanEvent() {

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
    public RanEvent(String title, String summary, LocalDate date, double duration, int difficulty, int participatingTeams) {
        super(title, summary, date, duration, difficulty, participatingTeams);
    }
}