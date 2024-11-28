package P1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TrainSystemMain {
	private static ArrayList<String> stations = new ArrayList<>(); // To store station names
    private static ArrayList<String[]> trains = new ArrayList<>(); // To store trains and their associated stations

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
        JButton sequenceButton = new JButton("Manage Sequences");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the menu panel
        menuPanel.add(stationButton);
        menuPanel.add(trackButton);
        menuPanel.add(trainButton);
        menuPanel.add(scheduleButton);
        menuPanel.add(sequenceButton);
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
        
        sequenceButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		manageSequences();
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
        JFrame stationFrame = new JFrame("Manage Stations");
        stationFrame.setSize(500, 400);

        // Create a table to display stations
        String[] columnNames = {"Station Name"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable stationTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(stationTable);

        // Add existing stations to the table
        for (String station : stations) {
            tableModel.addRow(new Object[]{station});
        }

        // Input field and buttons
        JTextField stationField = new JTextField(15);
        JButton addButton = new JButton("Add Station");
        JButton removeButton = new JButton("Remove Station");

        // Add station functionality
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stationName = stationField.getText().trim();
                if (!stationName.isEmpty() && !stations.contains(stationName)) {
                    stations.add(stationName);
                    tableModel.addRow(new Object[]{stationName});
                    stationField.setText("");
                } else {
                    JOptionPane.showMessageDialog(stationFrame, "Invalid or Duplicate Station Name", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Remove station functionality
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = stationTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String stationName = (String) tableModel.getValueAt(selectedRow, 0);
                    stations.remove(stationName);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(stationFrame, "Please select a station to remove", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> stationFrame.dispose());
        
        // Panel for input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Station Name: "));
        inputPanel.add(stationField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(closeButton);

        // Add components to the frame
        stationFrame.add(scrollPane, BorderLayout.CENTER);
        stationFrame.add(inputPanel, BorderLayout.SOUTH);

        stationFrame.setVisible(true);
    }

    private static void manageTracks() {
  
    	    JFrame trackFrame = new JFrame("Manage Tracks");
    	    trackFrame.setSize(600, 400);

    	    // List of stations
    	    DefaultListModel<String> stationListModel = new DefaultListModel<>();
    	    for (String station : stations) {
    	        stationListModel.addElement(station);
    	    }

    	    // JList for selecting stations
    	    JList<String> stationList = new JList<>(stationListModel);
    	    stationList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    	    // Track list table
    	    String[] columnNames = {"Track ID", "Start Station", "End Station"};
    	    DefaultTableModel trackTableModel = new DefaultTableModel(columnNames, 0);
    	    JTable trackTable = new JTable(trackTableModel);
    	    JScrollPane trackScrollPane = new JScrollPane(trackTable);

    	    // Add button to create a track
    	    JButton addTrackButton = new JButton("Add Track");
    	    addTrackButton.addActionListener(e -> {
    	        List<String> selectedStations = stationList.getSelectedValuesList();
    	        if (selectedStations.size() == 2) {
    	            String trackID = "Track-" + (trackTableModel.getRowCount() + 1);
    	            String startStation = selectedStations.get(0);
    	            String endStation = selectedStations.get(1);
    	            trackTableModel.addRow(new Object[]{trackID, startStation, endStation});
    	        } else {
    	            JOptionPane.showMessageDialog(trackFrame, "Please select exactly two stations to create a track.", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
    	    });

    	    // Remove button to delete a track
    	    JButton removeTrackButton = new JButton("Remove Selected Track");
    	    removeTrackButton.addActionListener(e -> {
    	        int selectedRow = trackTable.getSelectedRow();
    	        if (selectedRow != -1) {
    	            trackTableModel.removeRow(selectedRow);
    	        } else {
    	            JOptionPane.showMessageDialog(trackFrame, "Please select a track to remove.", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
    	    });

    	    JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> trackFrame.dispose());
    	    
    	    // Panel for buttons (Group small buttons to modify easily
    	    JPanel buttonPanel = new JPanel();
    	    buttonPanel.add(addTrackButton);
    	    buttonPanel.add(removeTrackButton);
    	    buttonPanel.add(closeButton);

    	    // Add components to the frame
    	    trackFrame.add(new JScrollPane(stationList), BorderLayout.WEST);
    	    trackFrame.add(trackScrollPane, BorderLayout.CENTER);
    	    trackFrame.add(buttonPanel, BorderLayout.SOUTH);

    	    trackFrame.setVisible(true);
    }

    private static void manageTrains() {
        JFrame trainFrame = new JFrame("Manage Trains");
        trainFrame.setSize(600, 400);

        // Create a table to display trains
        String[] columnNames = {"Train Name", "Stations"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable trainTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(trainTable);

        // Add existing trains to the table
        for (String[] train : trains) {
            tableModel.addRow(new Object[]{train[0], train[1]});
        }

        // Input fields and buttons
        JTextField trainField = new JTextField(15);
        JButton addButton = new JButton("Add Train");
        JButton removeButton = new JButton("Remove Train");
        JButton addStationsButton = new JButton("Add Stations to Train");

        // Add train functionality
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainName = trainField.getText().trim();
                if (!trainName.isEmpty() && trains.stream().noneMatch(t -> t[0].equals(trainName))) {
                    trains.add(new String[]{trainName, ""});
                    tableModel.addRow(new Object[]{trainName, ""});
                    trainField.setText("");
                } else {
                    JOptionPane.showMessageDialog(trainFrame, "Invalid or Duplicate Train Name", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Remove train functionality
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = trainTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String trainName = (String) tableModel.getValueAt(selectedRow, 0);
                    trains.removeIf(t -> t[0].equals(trainName));
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(trainFrame, "Please select a train to remove", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add stations to train functionality
        addStationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = trainTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String trainName = (String) tableModel.getValueAt(selectedRow, 0);

                    // Open a dialog to select stations
                    JFrame stationSelectionFrame = new JFrame("Select Stations for " + trainName);
                    stationSelectionFrame.setSize(400, 300);
                    stationSelectionFrame.setLayout(new BorderLayout());

                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (String station : stations) {
                        listModel.addElement(station);
                    }
                    JList<String> stationList = new JList<>(listModel);
                    stationList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                    JButton saveButton = new JButton("Save");

                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            java.util.List<String> selectedStations = stationList.getSelectedValuesList();
                            if (!selectedStations.isEmpty()) {
                                String stationsString = String.join(", ", selectedStations);
                                trains.stream().filter(t -> t[0].equals(trainName)).forEach(t -> t[1] = stationsString);
                                tableModel.setValueAt(stationsString, selectedRow, 1);
                                stationSelectionFrame.dispose();
                            } else {JOptionPane.showMessageDialog(stationSelectionFrame, "Please select at least one station", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                    stationSelectionFrame.add(new JScrollPane(stationList), BorderLayout.CENTER);
                    stationSelectionFrame.add(saveButton, BorderLayout.SOUTH);

                    stationSelectionFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(trainFrame, "Please select a train to add stations", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Panel for input and buttons (Group small buttons)
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Train Name: "));
        inputPanel.add(trainField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(addStationsButton);

        // Add components to the frame
        trainFrame.add(scrollPane, BorderLayout.CENTER);
        trainFrame.add(inputPanel, BorderLayout.SOUTH);

        trainFrame.setVisible(true);
    }

    private static void manageSchedules() {
    	JFrame scheduleFrame = new JFrame("Manage Schedules");
        scheduleFrame.setSize(600, 400);

        // Table to display schedules
        String[] columnNames = {"Train Name", "Stations (Sequence)", "Arrival Time", "Departure Time"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable scheduleTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);

        // Populate the schedule table with trains and their stations
        for (String[] train : trains) {
            if (!train[1].isEmpty()) { // Ensure train has stations
                String[] stationArray = train[1].split(", ");
                for (int i = 0; i < stationArray.length; i++) {
                    String arrivalTime = (i == 0) ? "N/A" : "10:00 AM"; // Example times
                    String departureTime = (i == stationArray.length - 1) ? "N/A" : "10:30 AM";
                    tableModel.addRow(new Object[]{train[0], stationArray[i], arrivalTime, departureTime});
                }
            }
        }

        // Button to close the schedule view
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> scheduleFrame.dispose());

        // Add components to the frame
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(closeButton);

        scheduleFrame.add(scrollPane, BorderLayout.CENTER);
        scheduleFrame.add(bottomPanel, BorderLayout.SOUTH);

        scheduleFrame.setVisible(true);
    }
    
    private static void manageSequences() {
    	JFrame sequencesFrame = new JFrame("Manage Sequences");
    	sequencesFrame.setSize(600, 400);
    	
    	String[] columnNames = {"SequenceNum", "StationID", "ScheduleID", "RouteID", "Arrival TIme", "Departure Time"};
    	DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    	JTable sequencesTable = new JTable(tableModel); 	// Create table object for sequences
    	JScrollPane scrollPane = new JScrollPane(sequencesTable);
    }
}
