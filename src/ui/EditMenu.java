package ui;

import backend.OutreachManager;
import backend.outreach.*;
import backend.outreach.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Controls the GUI for viewing and editing events
 protected String title;
 protected String summary;
 protected LocalDate date;
 protected int peopleReached;
 protected String photosLink;
 */
public class EditMenu extends JPanel {
    public EditMenu(JFrame frame, MainMenu mainMenu, OutreachManager manager, Outreach outreach) {
        setSize(600, 400);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTextArea titleArea = new JTextArea(outreach.getTitle(), 1, 20);
        JTextArea dateArea = new JTextArea(outreach.getDate().toString(), 1, 20);
        JTextArea peopleReachedArea = new JTextArea(Integer.toString(outreach.getPeopleReached()), 1, 20);
        JTextArea photosLinkArea = new JTextArea(outreach.getPhotosLink(), 1, 20);
        JTextArea summaryArea = new JTextArea(outreach.getSummary(), 5, 30);

        JScrollPane summaryScroll = new JScrollPane(summaryArea);

        titleArea.setFont(new Font("Segoe UI", Font.BOLD, 20));

        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        titleArea.setBorder(null);
        dateArea.setBorder(null);
        peopleReachedArea.setBorder(null);
        photosLinkArea.setBorder(null);
        summaryScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        summaryScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(new JLabel("Title:"));
        add(titleArea);
        add(new JLabel("Date (YYYY-MM-DD):"));
        add(dateArea);
        add(new JLabel("People Reached:"));
        add(peopleReachedArea);
        add(new JLabel("Photos Link:"));
        add(photosLinkArea);
        add(new JLabel("Summary:"));
        add(summaryScroll);

        // Individual types
        JTextArea durationArea = null;
        JTextArea difficultyArea = null;
        JTextArea participatingTeamsArea = null;
        JTextArea hostTeamArea = null;
        JTextArea recipientArea = null;
        JTextArea topicArea = null;
        JTextArea outcomeArea = null;
        JTextArea linkArea = null;

        if (outreach instanceof Event) {
            Event o = (Event) outreach;
            durationArea = new JTextArea(Double.toString(o.getDuration()), 1, 20);
            difficultyArea = new JTextArea(Integer.toString(o.getDifficulty()), 1, 20);
            participatingTeamsArea = new JTextArea(Integer.toString(o.getParticipatingTeams()), 1, 20);

            add(new JLabel("Duration (hours):"));
            add(durationArea);
            add(new JLabel("Difficulty (1 or 2):"));
            add(difficultyArea);
            add(new JLabel("# Participating Teams:"));
            add(participatingTeamsArea);
        }
        if (outreach instanceof SupportedEvent) {
            SupportedEvent o = (SupportedEvent) outreach;
            hostTeamArea = new JTextArea(o.getHostTeam(), 1, 20);

            add(new JLabel("Host Team:"));
            add(hostTeamArea);
        }
        if (outreach instanceof MentoredTeam) {
            MentoredTeam o = (MentoredTeam) outreach;
            recipientArea = new JTextArea(o.getRecipient(), 1, 20);
            durationArea = new JTextArea(Double.toString(o.getDuration()), 1, 20);

            add(new JLabel("Recipient Team:"));
            add(recipientArea);
            add(new JLabel("Duration:"));
            add(durationArea);
        }
        if (outreach instanceof AssistedTeam) {
            AssistedTeam o = (AssistedTeam) outreach;
            recipientArea = new JTextArea(o.getRecipient(), 1, 20);

            add(new JLabel("Recipient Team:"));
            add(recipientArea);
        }
        if (outreach instanceof Advocated) {
            Advocated o = (Advocated) outreach;
            topicArea = new JTextArea(o.getTopic(), 1, 20);
            outcomeArea = new JTextArea(o.getOutcome(), 1, 20);

            add(new JLabel("Topic:"));
            add(topicArea);
            add(new JLabel("Outcome:"));
            add(outcomeArea);
        }
        if (outreach instanceof PublishedResources) {
            PublishedResources o = (PublishedResources) outreach;
            linkArea = new JTextArea(o.getLinkToResource(), 1, 20);

            add(new JLabel("Link to Resource:"));
            add(linkArea);
        }
        if (outreach instanceof StartedTeam) {
            StartedTeam o = (StartedTeam) outreach;
            recipientArea = new JTextArea(o.getTeamStarted(), 1, 20);

            add(new JLabel("Team Name:"));
            add(recipientArea);
        }

        JButton saveButton = new JButton("Save/Close");
        JButton deleteButton = new JButton("Delete");

        saveButton.setMaximumSize(new Dimension(120, 50));
        saveButton.setMinimumSize(new Dimension(120, 50));
        deleteButton.setMaximumSize(new Dimension(120, 50));
        deleteButton.setMinimumSize(new Dimension(120, 50));

        add(saveButton);
        add(deleteButton);

        JTextArea finalDurationArea = durationArea;
        JTextArea finalParticipatingTeamsArea = participatingTeamsArea;
        JTextArea finalDifficultyArea = difficultyArea;
        JTextArea finalHostTeamArea = hostTeamArea;
        JTextArea finalRecipientArea = recipientArea;
        JTextArea finalOutcomeArea = outcomeArea;
        JTextArea finalTopicArea = topicArea;
        JTextArea finalLinkArea = linkArea;
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outreach.setTitle(titleArea.getText());
                outreach.setPeopleReached(Integer.parseInt(peopleReachedArea.getText()));
                outreach.setPhotosLink(photosLinkArea.getText());
                outreach.setSummary(summaryArea.getText());
                outreach.setDate(LocalDate.parse(dateArea.getText()));

                if (outreach instanceof Event) {
                    ((Event) outreach).setDuration(Double.parseDouble(finalDurationArea.getText()));
                    ((Event) outreach).setDifficulty(Integer.parseInt(finalDifficultyArea.getText()));
                    ((Event) outreach).setParticipatingTeams(Integer.parseInt(finalParticipatingTeamsArea.getText()));
                }
                if (outreach instanceof SupportedEvent) {
                    ((SupportedEvent) outreach).setHostTeam(finalHostTeamArea.getText());
                }
                if (outreach instanceof MentoredTeam) {
                    ((MentoredTeam) outreach).setRecipient(finalRecipientArea.getText());
                    ((MentoredTeam) outreach).setDuration(Double.parseDouble(finalDurationArea.getText()));
                }
                if (outreach instanceof AssistedTeam) {
                    ((AssistedTeam) outreach).setRecipient(finalRecipientArea.getText());
                }
                if (outreach instanceof Advocated) {
                    ((Advocated) outreach).setTopic(finalTopicArea.getText());
                    ((Advocated) outreach).setOutcome(finalOutcomeArea.getText());
                }
                if (outreach instanceof PublishedResources) {
                    ((PublishedResources) outreach).setLinkToResource(finalLinkArea.getText());
                }
                if (outreach instanceof StartedTeam) {
                    ((StartedTeam) outreach).setTeamStarted(finalRecipientArea.getText());
                }

                    setVisible(false);
                mainMenu.reloadOutreach();
                mainMenu.setVisible(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.removeOutreach(outreach);
                System.out.println(manager.showAll());
                setVisible(false);
                mainMenu.reloadOutreach();
                mainMenu.setVisible(true);
            }
        });

        frame.add(this);
        setVisible(true);
    }
}
