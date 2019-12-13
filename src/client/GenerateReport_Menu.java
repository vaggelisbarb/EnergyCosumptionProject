package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Toolkit;

public class GenerateReport_Menu {

	private JFrame frmReport;
	private JTextField pathFieldText;

	/**
	 * Launch the application.
	 */
	public static void NewScreen3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateReport_Menu window = new GenerateReport_Menu();
					window.frmReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GenerateReport_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReport = new JFrame();
		frmReport.setResizable(false);
		frmReport.setTitle("Report");
		frmReport.setBounds(100, 100, 450, 300);
		frmReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReport.getContentPane().setLayout(null);
		
		JLabel lblGenerateReportMenu = new JLabel("GENERATE REPORT MENU");
		lblGenerateReportMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerateReportMenu.setForeground(new Color(204, 51, 0));
		lblGenerateReportMenu.setFont(new Font("Manjari Bold", Font.BOLD, 17));
		lblGenerateReportMenu.setBounds(101, 0, 234, 28);
		frmReport.getContentPane().add(lblGenerateReportMenu);
		
		JLabel lblChooseTypeOf = new JLabel("Choose type of report : ");
		lblChooseTypeOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseTypeOf.setForeground(new Color(0, 255, 51));
		lblChooseTypeOf.setFont(new Font("Manjari Thin", Font.BOLD, 15));
		lblChooseTypeOf.setBounds(145, 142, 162, 28);
		frmReport.getContentPane().add(lblChooseTypeOf);
		
		JLabel lblEnterReportsFile = new JLabel("Enter Report's file path :");
		lblEnterReportsFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterReportsFile.setForeground(new Color(0, 255, 51));
		lblEnterReportsFile.setFont(new Font("Manjari Thin", Font.BOLD, 15));
		lblEnterReportsFile.setBounds(141, 52, 162, 28);
		frmReport.getContentPane().add(lblEnterReportsFile);
		
		pathFieldText = new JTextField();
		pathFieldText.setFont(new Font("FreeSans", Font.PLAIN, 14));
		pathFieldText.setHorizontalAlignment(SwingConstants.CENTER);
		pathFieldText.setToolTipText("Enter file path here or browse");
		pathFieldText.setForeground(new Color(0, 0, 0));
		pathFieldText.setColumns(10);
		pathFieldText.setBounds(114, 91, 206, 20);
		frmReport.getContentPane().add(pathFieldText);
		
		JButton btntxt = new JButton(".txt");
		btntxt.setIcon(new ImageIcon("images/Files-Txt-icon.png"));
		btntxt.setToolTipText("Select to generate a .txt report");
		btntxt.setForeground(new Color(204, 0, 0));
		btntxt.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		btntxt.setBounds(166, 182, 117, 28);
		frmReport.getContentPane().add(btntxt);
		
		JButton btnmd = new JButton(".md");
		btnmd.setIcon(new ImageIcon("images/text-x-markdown-icon.png"));
		btnmd.setToolTipText("Select to generate a .md report");
		btnmd.setForeground(new Color(204, 0, 0));
		btnmd.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		btnmd.setBounds(12, 182, 117, 28);
		frmReport.getContentPane().add(btnmd);
		
		
		JButton browse_button = new JButton("Browse");
		browse_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String path = null;
					MyCustomFileChooserRunner fr = new MyCustomFileChooserRunner();
					path = fr.MyCustomFileChooserScreen("Dir");
					pathFieldText.setText(path);
			}
		});
		browse_button.setIcon(new ImageIcon("images/Browse_icon.png"));
		browse_button.setFont(new Font("Manjari Regular", Font.BOLD | Font.ITALIC, 13));
		browse_button.setBounds(331, 92, 107, 20);
		frmReport.getContentPane().add(browse_button);

		
		JButton btnhtml = new JButton(".html");
		btnhtml.setIcon(new ImageIcon("images/html-icon.png"));
		btnhtml.setToolTipText("Select to generate a .html report");
		btnhtml.setForeground(new Color(204, 0, 0));
		btnhtml.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		btnhtml.setBounds(321, 182, 117, 28);
		frmReport.getContentPane().add(btnhtml);
		
		JLabel lblFilePath = new JLabel("File Path : ");
		lblFilePath.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilePath.setForeground(new Color(204, 0, 0));
		lblFilePath.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		lblFilePath.setBounds(23, 88, 94, 30);
		frmReport.getContentPane().add(lblFilePath);
		
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon("images/abstract-technology-particle-background_52683-25766.jpg"));
		BackGround.setHorizontalAlignment(SwingConstants.CENTER);
		BackGround.setBounds(0, 0, 465, 291);
		frmReport.getContentPane().add(BackGround);
	}
}
