package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.List;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class HistoryReports_Menu {
	
	static List reportsList; 
	private JFrame frmReportsHistory;
	

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
		getReports();
		initialize();
	}

	public String getReports() {
		if(!MainApplicationGui.reportsMap.isEmpty()) {
			Iterator<Map.Entry<String, String>> iterator = MainApplicationGui.reportsMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> obj = (Entry<String, String>) iterator.next();
				return obj.getKey();
			}
		}
		return null;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReportsHistory = new JFrame();
		frmReportsHistory.getContentPane().setBackground(Color.WHITE);
		frmReportsHistory.setResizable(false);
		frmReportsHistory.setTitle("Reports History");
		frmReportsHistory.setBounds(100, 100, 619, 378);
		frmReportsHistory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReportsHistory.getContentPane().setLayout(null);
		frmReportsHistory.getContentPane().setLayout(null);
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmReportsHistory.setVisible(false);
			}
		});
		btnReturn.setIcon(new ImageIcon("images/Industry-Return-icon.png"));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReturn.setForeground(new Color(204, 0, 0));
		btnReturn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		btnReturn.setBounds(460, 305, 136, 35);
		frmReportsHistory.getContentPane().add(btnReturn);
		
	
		JTextPane detailsPane = new JTextPane();
		detailsPane.setDragEnabled(true);
		detailsPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		detailsPane.setName("");
		detailsPane.setToolTipText("Details of the selected Report");
		detailsPane.setForeground(new Color(204, 0, 0));
		detailsPane.setEditable(false);
		detailsPane.setFont(new Font("Manjari Regular", Font.BOLD | Font.ITALIC, 14));
		detailsPane.setBackground(Color.WHITE);
		detailsPane.setBounds(238, 88, 353, 173);
		frmReportsHistory.getContentPane().add(detailsPane);	
		
		
		reportsList = new List();
		if(!MainApplicationGui.reportsMap.isEmpty()) {
			Iterator<Map.Entry<String, String>> iterator = MainApplicationGui.reportsMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> obj = (Entry<String, String>) iterator.next();
				reportsList.add(obj.getKey());
			}
		}
		reportsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				detailsPane.setText("");
				String target = reportsList.getSelectedItem();
				if(MainApplicationGui.reportsMap.containsKey(target))
					detailsPane.setText((String)MainApplicationGui.reportsMap.get(target));
			}
		});
		reportsList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reportsList.setMultipleSelections(false);
		reportsList.setFont(new Font("Manjari Regular", Font.BOLD, 17));
		reportsList.setBackground(Color.WHITE);
		reportsList.setBounds(32, 88, 145, 229);
		frmReportsHistory.getContentPane().add(reportsList);
		
		
		JLabel titleLabel = new JLabel("REPORTS HISTORY MENU");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(204, 51, 0));
		titleLabel.setFont(new Font("Manjari Bold", Font.BOLD, 17));
		titleLabel.setBounds(197, 0, 216, 51);
		frmReportsHistory.getContentPane().add(titleLabel);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setForeground(new Color(0, 255, 51));
		lblReports.setFont(new Font("Manjari Thin", Font.BOLD, 15));
		lblReports.setBounds(32, 59, 145, 23);
		frmReportsHistory.getContentPane().add(lblReports);
		
		JLabel lblReportsDetails = new JLabel("Report's Details");
		lblReportsDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportsDetails.setForeground(new Color(0, 255, 51));
		lblReportsDetails.setFont(new Font("Manjari Thin", Font.BOLD, 15));
		lblReportsDetails.setBounds(238, 59, 358, 23);
		frmReportsHistory.getContentPane().add(lblReportsDetails);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("images/abstract-technology-particle-background_52683-25766.jpg"));
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setBounds(0, 0, 619, 352);
		frmReportsHistory.getContentPane().add(background);
		
		
	}
}
