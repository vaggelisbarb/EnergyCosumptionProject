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
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Choice;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CreateStatistics_Menu {

	private JFrame frmStats;
	
	//Options of the timeUnit_combobox
	private String[] timeUnitOptions= {"Season" , "Month" , "WeekDay" , "Day Period"};
	
	//Options of Season
	private String [] seasonOption = {"Winter" , "Spring" , "Summer" , "Autumn"};
	
	//Options of Month
	private String [] monthOption = {"January",
									"February",
									"March",
									"April",
									"May",
									"June",
									"July",
									"August",
									"September",
									"October",
									"November",
									"December"};

	//Options of WeekDay
	private String [] weekdayOption = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
	
	//Option of Day Period
	private String [] dayPeriodOption = {"Early Morning (05.00-09.00) ","Morning (09.00-13.00) ","Afternoon (13.00-17.00)", "Evening (17.00-21.00) ","Night (21.00-05.00) "};
	/**
	 * Launch the application.
	 */
	public static void NewScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateStatistics_Menu window = new CreateStatistics_Menu();
					window.frmStats.setVisible(true);
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
		frmStats = new JFrame();
		frmStats.setTitle("Stats");
		frmStats.setBounds(100, 100, 450, 300);
		frmStats.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStats.getContentPane().setLayout(null);
		
		JLabel lblCreateStatisticsMenu = new JLabel("CREATE STATISTICS MENU");
		lblCreateStatisticsMenu.setFont(new Font("League Spartan Semibold", Font.BOLD, 17));
		lblCreateStatisticsMenu.setForeground(new Color(204, 51, 0));
		lblCreateStatisticsMenu.setBounds(131, 12, 189, 28);
		frmStats.getContentPane().add(lblCreateStatisticsMenu);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(28, 92, 170, 68);
		frmStats.getContentPane().add(splitPane);
		
		JRadioButton Average_btn = new JRadioButton("Average");
		splitPane.setLeftComponent(Average_btn);
		Average_btn.setForeground(new Color(204, 0, 0));
		Average_btn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		Average_btn.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton Sum_btn = new JRadioButton("Sum");
		Sum_btn.setHorizontalAlignment(SwingConstants.CENTER);
		Sum_btn.setForeground(new Color(204, 0, 0));
		Sum_btn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		splitPane.setRightComponent(Sum_btn);		
		
		
		JComboBox AfterSelect_box = new JComboBox();
		AfterSelect_box.setToolTipText("It's your choise now");
		AfterSelect_box.setVisible(false);
		AfterSelect_box.setForeground(new Color(204, 0, 0));
		AfterSelect_box.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		AfterSelect_box.setBounds(262, 136, 149, 24);
		frmStats.getContentPane().add(AfterSelect_box);

		
		JComboBox timeUnit_combobox = new JComboBox(timeUnitOptions);
		timeUnit_combobox.addActionListener(new ActionListener() {
			String isSelected = (String) timeUnit_combobox.getSelectedItem();
			public void actionPerformed(ActionEvent arg0) {
				if(isSelected.equals("Season")){
					AfterSelect_box.removeAllItems();
					AfterSelect_box.setVisible(true);
					AfterSelect_box.addItem(seasonOption[0]);
					AfterSelect_box.addItem(seasonOption[1]);
					AfterSelect_box.addItem(seasonOption[2]);
					AfterSelect_box.addItem(seasonOption[3]);
				}else if(isSelected.equals("Month")){
					AfterSelect_box.removeAllItems();
					AfterSelect_box.setVisible(true);
					AfterSelect_box.addItem(monthOption);
				}if(isSelected.equals("WeekDay")){
					AfterSelect_box.removeAllItems();
					AfterSelect_box.setVisible(true);
					AfterSelect_box.addItem(weekdayOption);	
				}if(isSelected.equals("Day Period")){
					AfterSelect_box.removeAllItems();
					AfterSelect_box.setVisible(true);
					AfterSelect_box.addItem(dayPeriodOption);
				}
			}
		});
		timeUnit_combobox.setToolTipText("Select the time period ");
		timeUnit_combobox.setForeground(new Color(204, 0, 0));
		timeUnit_combobox.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		timeUnit_combobox.setSelectedIndex(3);
		timeUnit_combobox.setBounds(262, 92, 149, 24);
		frmStats.getContentPane().add(timeUnit_combobox);
		
		JButton ConfirmStats_btn = new JButton("Confirm");
		ConfirmStats_btn.setForeground(new Color(204, 0, 0));
		ConfirmStats_btn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		ConfirmStats_btn.setBounds(131, 214, 189, 28);
		frmStats.getContentPane().add(ConfirmStats_btn);
		
		
		JLabel lblPeriodOfTime = new JLabel("Period of Time");
		lblPeriodOfTime.setForeground(new Color(51, 255, 0));
		lblPeriodOfTime.setFont(new Font("Manjari Regular", Font.PLAIN, 15));
		lblPeriodOfTime.setBounds(285, 52, 104, 28);
		frmStats.getContentPane().add(lblPeriodOfTime);
		
		JLabel lblChooseAggregationFunction = new JLabel(" Aggregation Function");
		lblChooseAggregationFunction.setForeground(new Color(51, 255, 0));
		lblChooseAggregationFunction.setFont(new Font("Manjari Regular", Font.PLAIN, 15));
		lblChooseAggregationFunction.setBounds(28, 52, 162, 28);
		frmStats.getContentPane().add(lblChooseAggregationFunction);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("/home/vaggelisbarb/Λήψεις/abstract-technology-particle-background_52683-25766.jpg"));
		Background.setHorizontalAlignment(SwingConstants.CENTER);
		Background.setBounds(0, 0, 465, 291);
		frmStats.getContentPane().add(Background);
	}
}
