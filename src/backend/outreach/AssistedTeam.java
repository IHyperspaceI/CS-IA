package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

public class AssistedTeam extends Outreach implements Serializable {
    String recipient;

    /**
     * Basic initialization
     */
    public AssistedTeam() {
        recipient = "";
    }

    /**
     * Initialize the object
     * @param recipient the team that was assisted
     * @param title outreach title
     * @param summary outreach summary
     * @param date date of assistance
     */
    public AssistedTeam(String recipient, String title, String summary, LocalDate date) {
        super(title, summary, date);
        this.recipient = recipient;
    }

    /**
     * Gets the name of the team that was assisted
     * @return team name
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Updates the name of the team that was assisted
     * @param recipient new name of team
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Gives a string of the outreach details
     * @return all the details listed as a string with new lines
     */
    public String toString() {
        return title + "\n" +
                date.toString() + "\n" +
                summary + "\n" +
                recipient;
    }
}
