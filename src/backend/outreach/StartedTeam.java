package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Handles the behavior for info on starting a team
 */
public class StartedTeam extends Outreach implements Serializable {
    private String teamStarted;

    /**
     * Initialize the outreach object
     */
    public StartedTeam() {
        teamStarted = "New FLL/FTC/FRC Team";
    }

    /**
     * Initialize the outreach object
     * @param teamStarted the name of the team that was started
     * @param title outreach title (what shows up in the UI)
     * @param summary summary of the outreach
     * @param date start date of the new team
     */
    public StartedTeam(String teamStarted, String title, String summary, LocalDate date) {
        super(title, summary, date);
        this.teamStarted = teamStarted;
    }

    /**
     * Get the name of the team that was started
     * @return new team's name
     */
    public String getTeamStarted() {
        return teamStarted;
    }

    /**
     * Change the name of the team that was started
     * @param teamStarted the new name
     */
    public void setTeamStarted(String teamStarted) {
        this.teamStarted = teamStarted;
    }

    /**
     * Gives a string of the outreach details
     * @return all the details listed as a string with new lines
     */
    public String toString() {
        return title + "\n" +
                date.toString() + "\n" +
                summary + "\n" +
                teamStarted;
    }
}
