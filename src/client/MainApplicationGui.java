package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import mainengine.IMainEngine;
import mainengine.MainEngine;
import mainengine.MainEngineFactory;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class MainApplicationGui {

	private JFrame frmSoftwareDevelopment;
	private MainEngineFactory mainenginefactory;
	private IMainEngine mainengine;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplicationGui window = new MainApplicationGui();
					window.frmSoftwareDevelopment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApplicationGui() {
		mainenginefactory = new MainEngineFactory();
		mainengine = mainenginefactory.createMainEngine("MainEngine");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSoftwareDevelopment = new JFrame();
		frmSoftwareDevelopment.setResizable(false);
		frmSoftwareDevelopment.setTitle("Software Development");
		frmSoftwareDevelopment.setFont(new Font("League Spartan Semibold", Font.PLAIN, 17));
		frmSoftwareDevelopment.setForeground(new Color(0, 204, 51));
		frmSoftwareDevelopment.setBounds(150, 150, 614, 300);
		frmSoftwareDevelopment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSoftwareDevelopment.getContentPane().setLayout(null);
		
		JButton load_button = new JButton("Load File");
		load_button.setToolTipText("Click to load a file");
		load_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadFile_Menu.NewScreen1();
			}
		});
		load_button.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/LoadFile.png"));
		load_button.setForeground(new Color(204, 0, 0));
		load_button.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		load_button.setBounds(130, 84, 338, 32);
		frmSoftwareDevelopment.getContentPane().add(load_button);
		
		JButton stats_button = new JButton("Create Statistics");
		stats_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateStatistics_Menu.NewScreen2();
			}
		});
		stats_button.setToolTipText("Click to create statistics");
		stats_button.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Statistics-icon.png"));
		stats_button.setForeground(new Color(204, 0, 0));
		stats_button.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		stats_button.setBounds(130, 128, 338, 32);
		frmSoftwareDevelopment.getContentPane().add(stats_button);
		
		JButton button_3 = new JButton("Exit");
		button_3.addActionListener(e -> System.exit(0));
		button_3.setToolTipText("Click to exit the programm");
		
		button_3.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/delete-icon.png"));
		button_3.setForeground(new Color(204, 0, 0));
		button_3.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		button_3.setBounds(434, 230, 168, 29);
		frmSoftwareDevelopment.getContentPane().add(button_3);
		
		JButton report_button = new JButton("Generate Report");
		report_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenerateReport_Menu.NewScreen3();
			}
		});
		report_button.setToolTipText("Click to generate a report");
		report_button.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Reports-icon.png"));
		report_button.setForeground(new Color(204, 0, 0));
		report_button.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		report_button.setBounds(130, 172, 338, 32);
		frmSoftwareDevelopment.getContentPane().add(report_button);
		
		JButton history_btn = new JButton("Reports History");
		history_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HistoryReports_Menu.NewScreen4();
			}
		});
		history_btn.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Rank-History-icon.png"));
		history_btn.setToolTipText("Click to view History of reports");
		history_btn.setForeground(new Color(204, 0, 0));
		history_btn.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		history_btn.setBounds(12, 230, 168, 29);
		frmSoftwareDevelopment.getContentPane().add(history_btn);
		
		
		JLabel lblEnergyConsumptionProject = new JLabel("ENERGY CONSUMPTION PROJECT");
		lblEnergyConsumptionProject.setFont(new Font("League Spartan Semibold", Font.BOLD, 20));
		lblEnergyConsumptionProject.setForeground(new Color(255, 51, 0));
		lblEnergyConsumptionProject.setBounds(164, 2, 273, 70);
		frmSoftwareDevelopment.getContentPane().add(lblEnergyConsumptionProject);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/vaggelisbarb/Λήψεις/rsz_abstract-technology-particle-background_52683-25766.jpg"));
		label.setBounds(0, 0, 614, 274);
		frmSoftwareDevelopment.getContentPane().add(label);
	}
}
