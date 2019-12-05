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
import mainengine.MainEngine;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApplicationGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplicationGui window = new MainApplicationGui();
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
	public MainApplicationGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 614, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Load File");
		button.setToolTipText("Click to load a file");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadFile_Menu loadFile_clk = new LoadFile_Menu();
				loadFile_clk.NewScreen1();
			}
		});
		button.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/LoadFile.png"));
		button.setForeground(new Color(204, 0, 0));
		button.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		button.setBounds(130, 84, 338, 32);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Create Statistics");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateStatistics_Menu crtStats_clk = new CreateStatistics_Menu();
				crtStats_clk.NewScreen2();
			}
		});
		button_1.setToolTipText("Click to create statistics");
		button_1.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Statistics-icon.png"));
		button_1.setForeground(new Color(204, 0, 0));
		button_1.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		button_1.setBounds(130, 128, 338, 32);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Report History");
		button_2.setToolTipText("View Report History");
		button_2.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Rank-History-icon.png"));
		button_2.setForeground(new Color(204, 0, 0));
		button_2.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		button_2.setBounds(12, 230, 142, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Exit");
		button_3.setToolTipText("Click to exit the programm");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/delete-icon.png"));
		button_3.setForeground(new Color(204, 0, 0));
		button_3.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		button_3.setBounds(460, 230, 142, 29);
		frame.getContentPane().add(button_3);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setToolTipText("Click to generate a report");
		btnGenerateReport.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Reports-icon.png"));
		btnGenerateReport.setForeground(new Color(204, 0, 0));
		btnGenerateReport.setFont(new Font("Manjari Bold", Font.BOLD, 13));
		btnGenerateReport.setBounds(130, 172, 338, 32);
		frame.getContentPane().add(btnGenerateReport);
		
		JLabel lblEnergyConsumptionProject = new JLabel("ENERGY CONSUMPTION PROJECT");
		lblEnergyConsumptionProject.setFont(new Font("League Spartan Semibold", Font.BOLD, 20));
		lblEnergyConsumptionProject.setForeground(new Color(255, 51, 0));
		lblEnergyConsumptionProject.setBounds(164, 2, 273, 70);
		frame.getContentPane().add(lblEnergyConsumptionProject);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/vaggelisbarb/Λήψεις/rsz_abstract-technology-particle-background_52683-25766.jpg"));
		label.setBounds(0, 0, 614, 274);
		frame.getContentPane().add(label);
		Image image = new ImageIcon(this.getClass().getResource("/energycons.jpeg")).getImage();
	}
}
