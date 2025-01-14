package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenu extends JPanel{
    private Event event;
    private JFrame frame;

    public EditMenu(JFrame frame) {
        this.frame = frame;
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton deleteButton = new JButton("Delete backend.Event");
        JButton returnButton = new JButton("Return");

        deleteButton.setPreferredSize(new Dimension(150, 50));
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setBorderPainted(true);
        deleteButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        deleteButton.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);

        returnButton.setPreferredSize(new Dimension(150, 50));
        returnButton.setBackground(Color.WHITE);
        returnButton.setBorderPainted(true);
        returnButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        returnButton.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);

        add(deleteButton);
        add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = new MainMenu(frame);
                setVisible(false);
                frame.revalidate();
            }
        });

        frame.add(this);
        revalidate();
    }
}
