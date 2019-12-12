package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import datamodel.IResult;
import mainengine.IMainEngine;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateStatistics_Menu {
	
	static IResult result;
	private JFrame frmStats;
	JTextField text_field;
	
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
	
	private JTextField textField;
	private JTextField textField_1;
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
	 * 
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
		frmStats.setResizable(false);
		frmStats.setTitle("Stats");
		frmStats.setBounds(100, 100, 450, 300);
		frmStats.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStats.getContentPane().setLayout(null);
		
		JLabel lblCreateStatisticsMenu = new JLabel("CREATE STATISTICS MENU");
		lblCreateStatisticsMenu.setFont(new Font("League Spartan Semibold", Font.BOLD, 17));
		lblCreateStatisticsMenu.setForeground(new Color(204, 51, 0));
		lblCreateStatisticsMenu.setBounds(131, 12, 189, 28);
		frmStats.getContentPane().add(lblCreateStatisticsMenu);
		
		JSplitPane aggFunction_split = new JSplitPane();
		aggFunction_split.setOrientation(JSplitPane.VERTICAL_SPLIT);
		aggFunction_split.setBounds(28, 80, 170, 68);
		frmStats.getContentPane().add(aggFunction_split);
		
		JRadioButton Average_btn = new JRadioButton("Average");
		aggFunction_split.setLeftComponent(Average_btn);
		Average_btn.setForeground(new Color(204, 0, 0));
		Average_btn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		Average_btn.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton Sum_btn = new JRadioButton("Sum");
		Sum_btn.setHorizontalAlignment(SwingConstants.CENTER);
		Sum_btn.setForeground(new Color(204, 0, 0));
		Sum_btn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		aggFunction_split.setRightComponent(Sum_btn);		
		
		ButtonGroup aggFunction = new ButtonGroup();
		aggFunction.add(Average_btn);
		aggFunction.add(Sum_btn);
		

		textField_1 = new JTextField();
		textField_1.setVisible(false);
		textField_1.setBounds(249, 116, 162, 32);
		frmStats.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		
		JComboBox timeUnit_combobox = new JComboBox(timeUnitOptions);
		timeUnit_combobox.addActionListener(new ActionListener() {
			int isSelected = timeUnit_combobox.getSelectedIndex();
			public void actionPerformed(ActionEvent arg0) { 
				
				int selected = timeUnit_combobox.getSelectedIndex();
				
				if (selected == 0) {
					textField_1.setVisible(true);
					textField_1.setToolTipText("Enter ONLY specific season. e.g WINTER,SUMMER,SPRING,AUTUMN");
				}else if (selected == 1) {
					textField_1.setVisible(true);
					textField_1.setToolTipText("Enter ONLY specific month. e.g JAN for January");
				}else if (selected == 2) {
					textField_1.setVisible(true);
					textField_1.setToolTipText("Enter ONLY specific day of week. e.g SUNDAY ");
				}else if (selected == 3) {
					textField_1.setVisible(true);
					textField_1.setToolTipText("Enter ONLY specific period of day. e.g NIGHT");
				}else {
					textField_1.setVisible(false);
				}
			}
		});
		
		
		timeUnit_combobox.setToolTipText("Select the time period ");
		timeUnit_combobox.setForeground(new Color(204, 0, 0));
		timeUnit_combobox.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		timeUnit_combobox.setSelectedIndex(-1);
		timeUnit_combobox.setBounds(249, 80, 162, 24);
		frmStats.getContentPane().add(timeUnit_combobox);
		
		
		JLabel GiveText_Label = new JLabel("Give Description");
		GiveText_Label.setHorizontalAlignment(SwingConstants.CENTER);
		GiveText_Label.setForeground(new Color(0, 255, 51));
		GiveText_Label.setFont(new Font("Manjari Thin", Font.BOLD, 15));
		GiveText_Label.setBounds(135, 160, 162, 28);
		frmStats.getContentPane().add(GiveText_Label);
		
		
		JLabel lblPeriodOfTime = new JLabel("Period of Time");
		lblPeriodOfTime.setForeground(new Color(0, 255, 51));
		lblPeriodOfTime.setFont(new Font("Manjari Thin", Font.BOLD, 15));
		lblPeriodOfTime.setBounds(281, 40, 104, 28);
		frmStats.getContentPane().add(lblPeriodOfTime);
		
		text_field = new JTextField();
		text_field.setToolTipText("Give a description text of the result.This will be displayed in the report");
		text_field.setFont(new Font("League Spartan Light", Font.BOLD, 14));
		text_field.setForeground(Color.BLACK);
		text_field.setBackground(Color.LIGHT_GRAY);
		text_field.setBounds(28, 189, 383, 28);
		frmStats.getContentPane().add(text_field);
		text_field.setColumns(10);
		
		
		JButton ConfirmStats_btn = new JButton("Confirm");
		ConfirmStats_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String btnIsSelected = null; 
				if (Sum_btn.isSelected())
					btnIsSelected = "sum";
				else if (Average_btn.isSelected())
					btnIsSelected = "avg";

				if(btnIsSelected!=null) {
					if(timeUnit_combobox.getSelectedIndex()==0) {
						if(textField_1.getText().equals("")){
							result = LoadFile_Menu.mainengine.aggregateByTimeUnit(LoadFile_Menu.objCollection,"SEASON" , btnIsSelected, text_field.getText());
							PopUp_FileLoad.PopUpLoad("Stats created for : " + textField_1.getText() + " with " + btnIsSelected.toUpperCase() + " function");
						}else if((textField_1.getText().equals("WINTER") || textField_1.getText().equals("SPRING") || textField_1.getText().equals("SUMMER") || textField_1.getText().equals("AUTUMN")) ){
							result = LoadFile_Menu.mainengine.aggregateByTimeUnit(LoadFile_Menu.objCollection,textField_1.getText() , btnIsSelected, text_field.getText());
							PopUp_FileLoad.PopUpLoad("Stats created for : " + textField_1.getText() + " with " + btnIsSelected.toUpperCase() + " function");
						}else
							PopUp_FileLoad.PopUpLoad("Enter valid Season in upper.");
					}else if(timeUnit_combobox.getSelectedIndex()==1){
						if(textField_1.getText().equals("")) {
							result = LoadFile_Menu.mainengine.aggregateByTimeUnit(LoadFile_Menu.objCollection, "MONTH", btnIsSelected, text_field.getText());
							PopUp_FileLoad.PopUpLoad("Stats created for : " + textField_1.getText() + " with " + btnIsSelected.toUpperCase() + " function");
						}else if (textField_1.getText().equals("JAN") || textField_1.getText().equals("FEB") || textField_1.getText().equals("MAR") || textField_1.getText().equals("APR") || (textField_1.getText().equals("MAY") || textField_1.getText().equals("JUN") || textField_1.getText().equals("JUL") || textField_1.getText().equals("AUG")) ||(textField_1.getText().equals("SEP") || textField_1.getText().equals("OCT") || textField_1.getText().equals("NOV") || textField_1.getText().equals("DEC"))  ) {
							result = LoadFile_Menu.mainengine.aggregateByTimeUnit(LoadFile_Menu.objCollection, textField_1.getText(), btnIsSelected, text_field.getText());
							PopUp_FileLoad.PopUpLoad("Stats created for : " + textField_1.getText() + " with " + btnIsSelected.toUpperCase() + " function");
						}else
							PopUp_FileLoad.PopUpLoad("Enter a month. (e.g JAN for January) ");
						
					}else if (timeUnit_combobox.getSelectedIndex()==2) {
						if(textField_1.getText().equals("")) {
							result = LoadFile_Menu.mainengine.aggregateByTimeUnit(LoadFile_Menu.objCollection, "dayofweek", btnIsSelected,text_field.getText() );
							PopUp_FileLoad.PopUpLoad("Stats created for : " + textField_1.getText() + " with " + btnIsSelected.toUpperCase() + " function");
						}else if(textField_1.getText().equals("MONDAY") || textField_1.getText().equals("TUESDAY") || textField_1.getText().equals("WEDNESDAY") || textField_1.getText().equals("THURSDAY") || (textField_1.getText().equals("FRIDAY") || textField_1.getText().equals("SATURDAY") || textField_1.getText().equals("SUNDAY") )) {
								result = LoadFile_Menu.mainengine.aggregateByTimeUnit(LoadFile_Menu.objCollection, textField_1.getText(), btnIsSelected,text_field.getText() );
								PopUp_FileLoad.PopUpLoad("Stats created for : " + textField_1.getText() + " with " + btnIsSelected.toUpperCase() + " function");
						}else
							PopUp_FileLoad.PopUpLoad("Enter valid day of week. (e.g SUNDAY) ");
					}else if (timeUnit_combobox.getSelectedIndex()==3) {
						if(textField_1.getText().equals("AFTERNOON")||textField_1.getText().equals("EVENING") || textField_1.getText().equals("EARLY_MORNING") || textField_1.getText().equals("MORNING") || textField_1.getText().equals("NIGHT")) {
							result = LoadFile_Menu.mainengine.aggregateByTimeUnit(LoadFile_Menu.objCollection, textField_1.getText(), btnIsSelected,text_field.getText() );
							PopUp_FileLoad.PopUpLoad("Stats created for : " + textField_1.getText() + " with " + btnIsSelected.toUpperCase() + " function");
						}else
							PopUp_FileLoad.PopUpLoad("Enter valid period of day. (e.g NIGHT)");
					}
				}else
					PopUp_FileLoad.PopUpLoad("Try Again please.");
	
				System.out.println("Kitchen consumption result for " +textField_1.getText() + " : " + result.getAggregateMeterKitchen());
				System.out.println("Laundry consumption result for " +textField_1.getText() + " : " + result.getAggregateMeterLaundry());
				System.out.println("AC consumption result for " +textField_1.getText() + " : " + result.getAggregateMeterAC());
			}
		});
		ConfirmStats_btn.setForeground(new Color(204, 0, 0));
		ConfirmStats_btn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		ConfirmStats_btn.setBounds(131, 234, 189, 28);
		frmStats.getContentPane().add(ConfirmStats_btn);
		
		
		JLabel lblChooseAggregationFunction = new JLabel(" Aggregation Function");
		lblChooseAggregationFunction.setForeground(new Color(0, 255, 51));
		lblChooseAggregationFunction.setFont(new Font("Manjari Thin", Font.BOLD, 15));
		lblChooseAggregationFunction.setBounds(28, 40, 162, 28);
		frmStats.getContentPane().add(lblChooseAggregationFunction);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("images/abstract-technology-particle-background_52683-25766.jpg"));
		Background.setHorizontalAlignment(SwingConstants.CENTER);
		Background.setBounds(0, 0, 465, 291);
		frmStats.getContentPane().add(Background);
		
		
	}
}
