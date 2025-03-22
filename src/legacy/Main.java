package legacy;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        OldSaveFileManager fileManager = new OldSaveFileManager("saved.json");
        OldEventManager manager = new OldEventManager(fileManager);
        manager.loadEvents();

        JFrame frame = new JFrame("Events");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MainMenu mainMenu = new MainMenu(frame);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        frame.setContentPane(mainPanel);

        mainPanel.add(mainMenu);

        frame.pack();
        frame.setVisible(true);
    }
}
