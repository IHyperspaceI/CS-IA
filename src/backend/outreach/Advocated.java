package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

public class Advocated extends Outreach implements Serializable {
    private String topic;
    private String outcome;

    /**
     * Default constructor
     */
    public Advocated() {
        this.topic = "";
        this.outcome = "";
    }

    /**
     * Initialize the object
     * @param topic topic advocated for
     * @param outcome outcome of advocacy
     * @param title title of advocacy project
     * @param summary summary of advocacy
     * @param date date of advocacy
     */
    public Advocated(String topic, String outcome, String title, String summary, LocalDate date) {
        super(title, summary, date);
        this.topic = topic;
        this.outcome = outcome;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    /**
     * Gives a string of the outreach details
     * @return all the details listed as a string with new lines
     */
    public String toString() {
        return title + "\n" +
                date.toString() + "\n" +
                summary + "\n" +
                topic + "\n" +
                outcome;
    }
}
