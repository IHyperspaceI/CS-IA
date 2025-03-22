package backend.outreach;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Stores data about published resources
 */
public class PublishedResources extends Outreach implements Serializable {
    private String linkToResource;

    /**
     * Basic initialization
     */
    public PublishedResources() {
        this.linkToResource = "";
    }

    /**
     * Initializes the outreach object
     * @param linkToResource link to the resource (if online)
     * @param title title
     * @param summary summary
     * @param date published date
     */
    public PublishedResources(String linkToResource, String title, String summary, LocalDate date) {
        super(title, summary, date);
        this.linkToResource = linkToResource;
    }

    /**
     * Gets the link to the resources (if posted online)
     * @return link
     */
    public String getLinkToResource() {
        return linkToResource;
    }

    /**
     * Updates the link to the resource (if posted online)
     * @param linkToResource the new link
     */
    public void setLinkToResource(String linkToResource) {
        this.linkToResource = linkToResource;
    }

    /**
     * Gives a string of the outreach details
     * @return all the details listed as a string with new lines
     */
    public String toString() {
        return title + "\n" +
                date.toString() + "\n" +
                summary + "\n" +
                linkToResource;
    }
}
