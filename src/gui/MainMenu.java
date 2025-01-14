package gui;
import backend.*;
import backend.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class MainMenu extends JPanel{
    private JFrame frame;
    public MainMenu(JFrame frame) {
        this.frame = frame;
        SaveFileManager fileManager = new SaveFileManager("saved.json");
        EventManager manager = new EventManager(fileManager);

        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton newEventButton = new JButton("New Event");
        newEventButton.setPreferredSize(new Dimension(150, 50));
        newEventButton.setBackground(Color.WHITE);
        newEventButton.setBorderPainted(true);
        newEventButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(newEventButton);

        JPanel eventsListPanel = new JPanel();
        eventsListPanel.setLayout(new BoxLayout(eventsListPanel, BoxLayout.Y_AXIS));
        eventsListPanel.setBackground(Color.DARK_GRAY);
        JScrollPane eventsListContainer = new JScrollPane(eventsListPanel);
        eventsListContainer.setPreferredSize(new Dimension(600, 300));
        eventsListContainer.createVerticalScrollBar();
        eventsListContainer.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        add(eventsListContainer);

        for (Event event : manager.getEvents()) {
            addEventLabel(eventsListPanel, event);
        }


        newEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Event templateEvent = new Event(manager.getEvents().size(), "New Event " + manager.getEvents().size(), "Testing...", LocalDate.now(), 0);
                manager.addEvent(templateEvent);
                manager.saveEvents();
                addEventLabel(eventsListPanel, templateEvent);
                revalidate();
            }
        });

        frame.add(this);
        revalidate();
    }

    public void addEventLabel(JPanel panel, Event event) {
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
        labelPanel.setBackground(Color.DARK_GRAY);
        labelPanel.setMaximumSize(new Dimension(550, 50));
        labelPanel.setMinimumSize(new Dimension(550, 50));

        JLabel nameLabel = new JLabel(event.getName());
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setMaximumSize(new Dimension(150, 50));
        nameLabel.setMinimumSize(new Dimension(150, 50));

        JLabel dateLabel = new JLabel(event.getDate().toString());
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setMaximumSize(new Dimension(150, 50));
        dateLabel.setMinimumSize(new Dimension(150, 50));

        JLabel durationLabel = new JLabel((event.getDuration()) + " hrs");
        durationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        durationLabel.setMaximumSize(new Dimension(50, 50));
        durationLabel.setMinimumSize(new Dimension(50, 50));

        JButton editButton = new JButton("View/Edit");
        editButton.setHorizontalAlignment(SwingConstants.RIGHT);
        editButton.setPreferredSize(new Dimension(75, 50));
        editButton.setBackground(Color.WHITE);
        editButton.setBorderPainted(true);
        editButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        labelPanel.add(nameLabel);
        labelPanel.add(dateLabel);
        labelPanel.add(durationLabel);
        labelPanel.add(editButton);
        panel.add(labelPanel);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMenu editMenu = new EditMenu(frame);
                setVisible(false);
            }
        });
    }
}