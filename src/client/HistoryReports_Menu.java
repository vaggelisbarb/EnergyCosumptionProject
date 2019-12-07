package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import java.awt.Point;
import java.awt.Cursor;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.event.ListSelectionEvent;

public class HistoryReports_Menu {

	private JFrame frmReportsHistory;
	private JTable table;
	private JTextPane descrpitonArea;
	

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
		frmReportsHistory.setTitle("Reports History");
		frmReportsHistory.setBounds(100, 100, 600, 280);
		frmReportsHistory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReportsHistory.getContentPane().setLayout(null);
		
		JList<String> reportsList = new JList<String>();
		reportsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(reportsList.getSelectedIndex() != -1) {
					String selectedReport = reportsList.getSelectedValue();
					//descrpitonArea.setText(selectedReport);
				}
			}
		});
		
		reportsList.setVisibleRowCount(3);
		reportsList.setForeground(new Color(0, 0, 0));
		reportsList.setFont(new Font("League Spartan Light", Font.BOLD, 17));
		reportsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reportsList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Report 1asdasdada", "Report 2sdasdasdasd", "Report 3", "Report 4asdasda", "Report 5", "Report 6"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		reportsList.setSelectedIndex(0);
		JScrollPane scrollableTextArea = new JScrollPane(reportsList);
		scrollableTextArea.setSize(419, 143);
		scrollableTextArea.setLocation(75, 12);
		scrollableTextArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollableTextArea.setMaximumSize(new Dimension(3276, 3276));
		scrollableTextArea.setPreferredSize(new Dimension(440,150));
		scrollableTextArea.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReports.setIconTextGap(5);
		lblReports.setForeground(new Color(204, 0, 0));
		lblReports.setFont(new Font("League Spartan Light", Font.BOLD, 17));
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		scrollableTextArea.setColumnHeaderView(lblReports);
		
		descrpitonArea = new JTextPane();
		descrpitonArea.setForeground(Color.DARK_GRAY);
		descrpitonArea.setFont(new Font("League Spartan Light", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frmReportsHistory.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(descrpitonArea, Alignment.LEADING)
						.addComponent(scrollableTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(75))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(descrpitonArea, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		frmReportsHistory.getContentPane().setLayout(groupLayout);
		
		
	}
}
