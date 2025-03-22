package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The base class for outreach types
 */
public abstract class Outreach implements Comparable, Serializable {
    protected String title;
    protected String summary;
    protected LocalDate date;
    protected int peopleReached;
    protected String photosLink;

    /**
     * Basic initialization
     */
    public Outreach() {
        this.title = "New Event";
        this.summary = "New event summary";
        this.date = LocalDate.of(2013, 1, 5);
        this.photosLink = "";
    }

    /**
     * Specified initialization
     * @param title outreach title (what shows up in the UI)
     * @param summary of the outreach
     * @param date start date of the outreach
     */
    public Outreach(String title, String summary, LocalDate date) {
        this.title = title;
        this.summary = summary;
        this.date = date;
        this.photosLink = "";
    }

    /**
     * Gets the outreach title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the display title of the outreach
     * @param title new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the summary of the outreach
     * @return outreach summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Updates the outreach summary
     * @param summary new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the date of the outreach
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Updates the outreach date
     * @param date new date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the number of people reached during the outreach
     * @return number of people reached
     */
    public int getPeopleReached() {
        return peopleReached;
    }

    /**
     * Updates the number of people reached during the event
     * @param peopleReached new number of people reached
     */
    public void setPeopleReached(int peopleReached) {
        this.peopleReached = peopleReached;
    }

    /**
     * Gets the link to the hosting website of outreach pictures (Google Drive, etc.)
     * @return folder link
     */
    public String getPhotosLink() {
        return photosLink;
    }


    /**
     * Updates the link to the hosting website of outreach pictures (Google Drive, etc.)
     * @param photosLink folder link
     */
    public void setPhotosLink(String photosLink) {
        this.photosLink = photosLink;
    }

    /**
     * Compares this event to another event based on date
     * @param other the object to be compared.
     * @return -1, 0, or 1 based on order
     */
    public int compareTo(Object other) {
        if (other instanceof Outreach) {
            Outreach otherOutreach = (Outreach) other;

            return otherOutreach.getDate().compareTo(this.date);
        }

        return 0;
    }

    /**
     * Gives a string of the outreach details
     * @return all the details listed as a string with new lines
     */
    public String toString() {
        return title + "\n" +
                date.toString() + "\n" +
                summary;
    }
}
