package ui;

import backend.filemanagement.FileHandler;
import backend.outreach.*;
import backend.OutreachManager;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("outreach_data.ser");
        OutreachManager manager = new OutreachManager(fileHandler.loadOutreachList());

        // Examples pls remove
        // Outreach event1 = new HostedEvent("FLL Qualifier", "FLL go brrr", LocalDate.of(2026, 4, 15), 10, 1, 15);
        // Outreach event2 = new MentoredTeam("Team Beta", 2.0, "Strategy Session", "Discussed competition strategy", LocalDate.of(2025, 5, 10));

        //manager.addOutreach(event1);
        //manager.addOutreach(event2);

        for (Outreach o : manager.getAll()) {
            System.out.println("\n" + o.toString());
        }

        System.out.println(manager.showAll());

        fileHandler.saveOutreach(manager.getAll());
    }
}
