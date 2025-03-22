package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Stores information about an outreach event where your team mentored another team
 */
public class MentoredTeam extends Outreach implements Serializable {
    private String recipient;
    private double duration;

    public MentoredTeam() {
        this.recipient = "Recieving Team Name";
        this.duration = 0;
    }

    /**
     * Initialize the outreach object
     * @param recipient the name of the team that received mentorship
     * @param duration how long the team mentored the other team (hours)
     * @param title outreach title
     * @param summary summary of the outreach
     * @param date date of mentorship
     */
    public MentoredTeam(String recipient, double duration, String title, String summary, LocalDate date) {
        super(title, summary, date);
        this.recipient = recipient;
        this.duration = duration;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Gives a string of the outreach details
     * @return all the details listed as a string with new lines
     */
    public String toString() {
        return title + "\n" +
                date.toString() + "\n" +
                summary + "\n" +
                recipient + "\n" +
                duration;
    }
}
