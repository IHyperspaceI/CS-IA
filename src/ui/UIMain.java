package ui;

import backend.OutreachManager;
import backend.filemanagement.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UIMain{
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("outreach_data.ser");
        OutreachManager manager = new OutreachManager(fileHandler.loadOutreachList());

        setLookAndFeel();

        JFrame frame = new JFrame("Outreach");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        MainMenu mainMenu = new MainMenu(frame, manager);

        mainPanel.add(mainMenu);
        frame.setContentPane(mainPanel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("App is closing");
                fileHandler.saveOutreach(manager.getAll());
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("App is closed");
                // Perform actions after closing
            }
        });


        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Applies a global UI theme.
     */
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            Color DARK_BG = new Color(30, 30, 30);
            Color BUTTON_BG = new Color(35, 35, 35);
            Color LIGHT_TEXT = Color.decode("#EEEEEE");
            Color ACCENT_COLOR = Color.decode("#76ABAE");

            UIManager.put("Panel.background", DARK_BG);
            UIManager.put("Frame.background", DARK_BG);
            UIManager.put("Label.foreground", LIGHT_TEXT);
            UIManager.put("Button.foreground", BUTTON_BG);
            UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 14));
            UIManager.put("Button.setBorderPainted", true);

            UIManager.put("TextArea.background", DARK_BG);
            UIManager.put("TextArea.foreground", LIGHT_TEXT);
            UIManager.put("TextArea.border", BorderFactory.createLineBorder(LIGHT_TEXT, 1));
            UIManager.put("ScrollPane.background", DARK_BG);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
