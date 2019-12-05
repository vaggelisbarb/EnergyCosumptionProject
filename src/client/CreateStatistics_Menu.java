package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class CreateStatistics_Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateStatistics_Menu window = new CreateStatistics_Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateStatistics_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateStatisticsMenu = new JLabel("CREATE STATISTICS MENU");
		lblCreateStatisticsMenu.setFont(new Font("League Spartan Semibold", Font.BOLD, 17));
		lblCreateStatisticsMenu.setForeground(new Color(204, 51, 0));
		lblCreateStatisticsMenu.setBounds(131, 12, 189, 28);
		frame.getContentPane().add(lblCreateStatisticsMenu);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(28, 111, 170, 68);
		frame.getContentPane().add(splitPane);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Average");
		splitPane.setLeftComponent(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(new Color(204, 0, 0));
		rdbtnNewRadioButton.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnSum = new JRadioButton("Sum");
		rdbtnSum.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSum.setForeground(new Color(204, 0, 0));
		rdbtnSum.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		splitPane.setRightComponent(rdbtnSum);
		
		JLabel lblPeriodOfTime = new JLabel("Period of Time");
		lblPeriodOfTime.setForeground(new Color(51, 255, 0));
		lblPeriodOfTime.setFont(new Font("Manjari Regular", Font.PLAIN, 15));
		lblPeriodOfTime.setBounds(283, 71, 104, 28);
		frame.getContentPane().add(lblPeriodOfTime);
		
		JLabel lblChooseAggregationFunction = new JLabel(" Aggregation Function");
		lblChooseAggregationFunction.setForeground(new Color(51, 255, 0));
		lblChooseAggregationFunction.setFont(new Font("Manjari Regular", Font.PLAIN, 15));
		lblChooseAggregationFunction.setBounds(36, 71, 162, 28);
		frame.getContentPane().add(lblChooseAggregationFunction);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/vaggelisbarb/Λήψεις/abstract-technology-particle-background_52683-25766.jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 465, 291);
		frame.getContentPane().add(label);
	}
}
