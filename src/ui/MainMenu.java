package ui;

import backend.OutreachManager;
import backend.outreach.Outreach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class MainMenu extends JPanel {
    private MainMenu thisMenu;
    private JFrame frame;
    private ArrayList<JPanel> outreachLabels;
    private OutreachManager manager;
    private JPanel eventsListPanel;

    public MainMenu(JFrame frame, OutreachManager manager) {
        this.frame = frame;
        this.thisMenu = this;
        this.manager = manager;
        this.outreachLabels = new ArrayList<>();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton newEventButton = new JButton("New Event");
        newEventButton.setPreferredSize(new Dimension(150, 50));
        newEventButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(newEventButton);

        eventsListPanel = new JPanel();
        eventsListPanel.setLayout(new BoxLayout(eventsListPanel, BoxLayout.Y_AXIS));

        JScrollPane eventsListContainer = new JScrollPane(eventsListPanel);
        eventsListContainer.setPreferredSize(new Dimension(600, 300));
        eventsListContainer.createVerticalScrollBar();
        eventsListContainer.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        add(eventsListContainer);

        for (Outreach outreach : manager.getAll()) {
            outreachLabels.add(addOutreachLabel(eventsListPanel, outreach, manager));
        }


        newEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewEventMenu(manager, eventsListPanel, thisMenu);
            }
        });

        frame.add(this);
        revalidate();
    }

    public void reloadOutreach() {
        eventsListPanel.removeAll();

        for (Outreach outreach : manager.getAll()) {
            outreachLabels.add(addOutreachLabel(eventsListPanel, outreach, manager));
        }

        eventsListPanel.revalidate();
        revalidate();
    }

    public JPanel addOutreachLabel(JPanel panel, Outreach outreach, OutreachManager manager) {
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
        labelPanel.setMaximumSize(new Dimension(550, 50));
        labelPanel.setMinimumSize(new Dimension(550, 50));

        JLabel nameLabel = new JLabel(outreach.getTitle());
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setMaximumSize(new Dimension(150, 50));
        nameLabel.setMinimumSize(new Dimension(150, 50));

        JLabel dateLabel = new JLabel(outreach.getDate().toString());
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setMaximumSize(new Dimension(150, 50));
        dateLabel.setMinimumSize(new Dimension(150, 50));


        JLabel typeLabel = new JLabel((outreach.getClass().getSimpleName()));
        typeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        typeLabel.setMaximumSize(new Dimension(120, 50));
        typeLabel.setMinimumSize(new Dimension(120, 50));


        JButton editButton = createEditButton();

        labelPanel.add(nameLabel);
        labelPanel.add(dateLabel);
        labelPanel.add(typeLabel);
        labelPanel.add(editButton);
        panel.add(labelPanel);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMenu editMenu = new EditMenu(frame, thisMenu, manager, outreach);
                thisMenu.setVisible(false);
            }
        });

        return labelPanel;
    }

    private JButton createEditButton() {
        JButton editButton = new JButton("View/Edit");
        editButton.setHorizontalAlignment(SwingConstants.RIGHT);
        editButton.setPreferredSize(new Dimension(75, 50));
        editButton.setBorderPainted(true);
        editButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return editButton;
    }
}