package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;

import reporting.IResultReporter;

import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;

public class HistoryReports_Menu {
	
	private JFrame frmReportsHistory;
	private JTextField descriptionField;
	

	/**
	 * Launch the application.
	 */
	public static void NewScreen4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryReports_Menu window = new HistoryReports_Menu();
					window.frmReportsHistory.setVisible(true);
				} catch (Exception e) {
					
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HistoryReports_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReportsHistory = new JFrame();
		frmReportsHistory.getContentPane().setBackground(Color.DARK_GRAY);
		frmReportsHistory.setResizable(false);
		frmReportsHistory.setTitle("Reports History");
		frmReportsHistory.setBounds(100, 100, 600, 280);
		frmReportsHistory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReportsHistory.getContentPane().setLayout(null);
		
		JList<String> reportsList = new JList<String>();
		reportsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(reportsList.getSelectedIndex() == 0) {
					descriptionField.setText("AEK");
				}
			}
		});
		
		reportsList.setVisibleRowCount(3);
		reportsList.setForeground(new Color(0, 0, 0));
		reportsList.setFont(new Font("Manjari Regular", Font.BOLD, 16));
		reportsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reportsList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Report 1", "Report2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		JScrollPane scrollableTextArea = new JScrollPane(reportsList);
		scrollableTextArea.setSize(419, 143);
		scrollableTextArea.setLocation(75, 12);
		scrollableTextArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollableTextArea.setMaximumSize(new Dimension(3276, 3276));
		scrollableTextArea.setPreferredSize(new Dimension(440,150));
		scrollableTextArea.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblReports = new JLabel("REPORTS");
		lblReports.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReports.setIconTextGap(5);
		lblReports.setForeground(new Color(204, 0, 0));
		lblReports.setFont(new Font("Manjari Regular", Font.BOLD, 17));
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		scrollableTextArea.setColumnHeaderView(lblReports);
		
		descriptionField = new JTextField();
		descriptionField.setText("sdasd");
		descriptionField.setFont(new Font("Manjari Regular", Font.BOLD | Font.ITALIC, 14));
		descriptionField.setForeground(Color.RED);
		descriptionField.setEditable(false);
		descriptionField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmReportsHistory.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(descriptionField, Alignment.LEADING)
						.addComponent(scrollableTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(85))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(descriptionField, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addContainerGap())
		);
		frmReportsHistory.getContentPane().setLayout(groupLayout);
		
		
	}
}
