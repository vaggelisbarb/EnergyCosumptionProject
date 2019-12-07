package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class PopUp_FileLoad {

	private JFrame frmMessage;
	private JTextField textField;
	private JButton ok_btn;
	String option;

	/**
	 * Launch the application.
	 */
	public static void PopUpLoad(String option) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUp_FileLoad window = new PopUp_FileLoad(option);
					window.frmMessage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PopUp_FileLoad(String option) {
		this.option = option;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMessage = new JFrame();
		frmMessage.setResizable(false);
		frmMessage.setTitle("Message");
		frmMessage.setBounds(100, 100, 400, 200);
		
		frmMessage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMessage.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		if(option.equals("OK"))
			textField.setText("File has been loaded succesfully!!"+"\n");
		else if(option.equals("Fail"))
			textField.setText("Error : File cannot be loaded.");
		else if(option.equals("enter_file"))
			textField.setText("Please give or browse a file");
		
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("League Spartan", Font.BOLD, 17));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(50, 32, 282, 32);
		frmMessage.getContentPane().add(textField);
		textField.setColumns(10);
		
		ok_btn = new JButton("OK");
		ok_btn.setForeground(new Color(204, 0, 0));
		ok_btn.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		ok_btn.setBounds(137, 96, 117, 28);
		frmMessage.getContentPane().add(ok_btn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/images/abstract-technology-particle-background_52683-25766.jpg"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 402, 181);
		frmMessage.getContentPane().add(label);
	}
}
