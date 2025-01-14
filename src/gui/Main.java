package gui;

import backend.Event;
import backend.EventManager;
import backend.SaveFileManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SaveFileManager fileManager = new SaveFileManager("saved.json");
        EventManager manager = new EventManager(fileManager);
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
