package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class LoadFile_Menu {

	private JFrame frmSoftwareDevelpomentAssignment;
	private JTextField path_field;

	/**
	 * Launch the application.
	 */
	public static void NewScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadFile_Menu window = new LoadFile_Menu();
					window.frmSoftwareDevelpomentAssignment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoadFile_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSoftwareDevelpomentAssignment = new JFrame();
		frmSoftwareDevelpomentAssignment.setTitle("Load File");
		frmSoftwareDevelpomentAssignment.setBounds(100, 100, 450, 300);
		frmSoftwareDevelpomentAssignment.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSoftwareDevelpomentAssignment.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("LOAD FILE MENU");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(204, 51, 0));
		label.setFont(new Font("League Spartan Semibold", Font.BOLD, 17));
		label.setBounds(109, 12, 216, 51);
		frmSoftwareDevelpomentAssignment.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("File Path");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(204, 0, 0));
		label_1.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		label_1.setBounds(12, 108, 94, 30);
		frmSoftwareDevelpomentAssignment.getContentPane().add(label_1);
		
		path_field = new JTextField();
		path_field.setHorizontalAlignment(SwingConstants.CENTER);
		path_field.setForeground(new Color(0, 0, 0));
		path_field.setToolTipText("Enter file path here or browse");
		path_field.setBounds(103, 107, 206, 20);
		frmSoftwareDevelpomentAssignment.getContentPane().add(path_field);
		path_field.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String path = null;
				MyCustomFileChooserRunner fr = new MyCustomFileChooserRunner();
				path = fr.MyCustomFileChooserScreen("Files");
				path_field.setText(path);
			}
		});
		btnBrowse.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Browse_icon.png"));
		btnBrowse.setFont(new Font("Manjari Regular", Font.BOLD | Font.ITALIC, 13));
		btnBrowse.setBounds(321, 107, 107, 20);
		frmSoftwareDevelpomentAssignment.getContentPane().add(btnBrowse);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		btnConfirm.setForeground(new Color(204, 0, 0));
		btnConfirm.setBounds(159, 147, 117, 28);
		frmSoftwareDevelpomentAssignment.getContentPane().add(btnConfirm);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApplicationGui return_clk = new MainApplicationGui();
			}
		});
		btnReturn.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Industry-Return-icon.png"));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReturn.setForeground(new Color(204, 0, 0));
		btnReturn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		btnReturn.setBounds(321, 230, 107, 28);
		frmSoftwareDevelpomentAssignment.getContentPane().add(btnReturn);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/home/vaggelisbarb/Λήψεις/abstract-technology-particle-background_52683-25766.jpg"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 0, 465, 291);
		frmSoftwareDevelpomentAssignment.getContentPane().add(label_2);
	}
}
