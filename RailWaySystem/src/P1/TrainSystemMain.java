package P1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TrainSystemMain {
	 public static void main(String[] args) {
	        // Create the main frame
	        JFrame frame = new JFrame("Train Management System");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 400);

	        // Create a panel for the menu
	        JPanel menuPanel = new JPanel();
	        menuPanel.setLayout(new GridLayout(5, 1));

	        // Create buttons for different actions
	        JButton stationButton = new JButton("Manage Stations");
	        JButton trackButton = new JButton("Manage Tracks");
	        JButton trainButton = new JButton("Manage Trains");
	        JButton scheduleButton = new JButton("Manage Schedules");
	        JButton exitButton = new JButton("Exit");

	        // Add buttons to the menu panel
	        menuPanel.add(stationButton);
	        menuPanel.add(trackButton);
	        menuPanel.add(trainButton);
	        menuPanel.add(scheduleButton);
	        menuPanel.add(exitButton);

	        // Add the menu panel to the frame
	        frame.add(menuPanel);

	        // Action listeners for buttons
	        stationButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                manageStations();
	            }
	        });

	        trackButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                manageTracks();
	            }
	        });

	        trainButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                manageTrains();
	            }
	        });

	        scheduleButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                manageSchedules();
	            }
	        });

	        exitButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });

	        // Make the frame visible
	        frame.setVisible(true);
	    }

	    private static void manageStations() {
	        JOptionPane.showMessageDialog(null, "Station Management: Add, Edit, or View Stations.");
	    }

	    private static void manageTracks() {
	        JOptionPane.showMessageDialog(null, "Track Management: Connect Stations with Tracks.");
	    }

	    private static void manageTrains() {
	        JOptionPane.showMessageDialog(null, "Train Management: Add or View Train Details.");
	    }

	    private static void manageSchedules() {
	        // Create a new frame for schedule management
	        JFrame scheduleFrame = new JFrame("Manage Schedules");
	        scheduleFrame.setSize(800, 400);

	        // Create a table to display train schedules
	        String[] columnNames = {"Sequence", "Station Name", "Arrival Time", "Departure Time"};
	        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
	        JTable scheduleTable = new JTable(tableModel);

	        // Add sample data (placeholder)
	        List<String[]> scheduleData = new ArrayList<>();
	        scheduleData.add(new String[]{"1", "Delhi", "08:00 AM", "08:10 AM"});
	        scheduleData.add(new String[]{"2", "Lucknow", "12:00 PM", "12:15 PM"});
	        scheduleData.add(new String[]{"3", "Kolkata", "06:00 PM", ""});

	        for (String[] row : scheduleData) {
	            tableModel.addRow(row);
	        }

	        // Add the table to a scroll pane
	        JScrollPane scrollPane = new JScrollPane(scheduleTable);
	        scheduleFrame.add(scrollPane, BorderLayout.CENTER);

	        // Add a button to add new schedule rows
	        JButton addButton = new JButton("Add Schedule");
	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                tableModel.addRow(new String[]{"", "", "", ""});
	            }
	        });

	        // Add a panel for the button
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.add(addButton);
	        scheduleFrame.add(buttonPanel, BorderLayout.SOUTH);

	        // Show the frame
	        scheduleFrame.setVisible(true);
	    }
}
