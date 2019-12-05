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

public class LoadFile_Menu {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadFile_Menu window = new LoadFile_Menu();
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
	public LoadFile_Menu() {
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
		
		JLabel label = new JLabel("LOAD FILE MENU");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(204, 51, 0));
		label.setFont(new Font("League Spartan Semibold", Font.BOLD, 17));
		label.setBounds(109, 12, 216, 51);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("File Path");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(204, 0, 0));
		label_1.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		label_1.setBounds(12, 108, 94, 30);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(51, 255, 51));
		textField.setToolTipText("Enter file path here or browse");
		textField.setBounds(103, 107, 206, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/Browse_icon.png"));
		btnNewButton.setFont(new Font("Manjari Regular", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(321, 107, 107, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		btnConfirm.setForeground(new Color(204, 0, 0));
		btnConfirm.setBounds(159, 147, 117, 28);
		frame.getContentPane().add(btnConfirm);
		
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
		frame.getContentPane().add(btnReturn);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/home/vaggelisbarb/Λήψεις/abstract-technology-particle-background_52683-25766.jpg"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 0, 465, 291);
		frame.getContentPane().add(label_2);
	}
}
