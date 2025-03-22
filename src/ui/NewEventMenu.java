package ui;

import backend.OutreachManager;
import backend.outreach.*;
import backend.outreach.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls the GUI for adding a new event
 */
public class NewEventMenu extends JDialog{
    public NewEventMenu(OutreachManager manager, JPanel eventsListPanel, MainMenu mainMenu) {
        super((Frame) null, "Create New Outreach", true);
        setSize(400, 100);
        setLayout(new FlowLayout());

        String[] outreachTypes = {
                "Mentored Team", "Assisted Team", "Started Team", "Event", "Hosted Event",
                "Ran Event", "Supported Event", "Advocacy", "Published Resources"
        };

        JComboBox<String> dropdown = new JComboBox<>(outreachTypes);

        JButton createButton = new JButton("Create Outreach");

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) dropdown.getSelectedItem();
                Outreach outreach = createOutreachInstance(selectedType);

                manager.addOutreach(outreach);

                mainMenu.addOutreachLabel(eventsListPanel, outreach, manager);
                eventsListPanel.revalidate();
                eventsListPanel.repaint();

                dispose();
            }
        });

        add(new JLabel("Select an Outreach Type:"));
        add(dropdown);
        add(createButton);

        setLocationRelativeTo(null);

        setVisible(true);
    }


    /**
     * Create the correct Objects based on the input
     * @param type which object to create
     * @return the correct child of Outreach
     */
    private static Outreach createOutreachInstance(String type) {
        return switch (type) {
            case "Mentored Team" -> new MentoredTeam();
            case "Assisted Team" -> new AssistedTeam();
            case "Started Team" -> new StartedTeam();
            case "Event" -> new Event();
            case "Hosted Event" -> new HostedEvent();
            case "Ran Event" -> new RanEvent();
            case "Supported Event" -> new SupportedEvent();
            case "Advocacy" -> new Advocated();
            case "Published Resources" -> new PublishedResources();
            default -> new Event();
        };
    }
}
