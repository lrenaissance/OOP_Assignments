package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import player.요시;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class StartView extends JFrame {

	private JPanel contentPane;
	private JLabel bg;
	private JButton startBtn;
	private JLabel titleLabel;
	private JTextPane scenario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView frame = new StartView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 518);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setTitle("키노피오 구출 대작전");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Image m1=new ImageIcon(this.getClass().getResource("/img/start.png")).getImage(); Image
		m2=m1.getScaledInstance(this.getSize().width,this.getSize().height,Image.SCALE_SMOOTH); ImageIcon m3=new ImageIcon(m2);
		
		startBtn = new JButton("START");
		startBtn.setFont(new Font("굴림", Font.PLAIN, 48));
		startBtn.setBounds(321, 348, 214, 59);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new choosePlayer().setVisible(true);
				dispose();
			}
		});
		contentPane.add(startBtn);
		
		titleLabel = new JLabel("\uD0A4\uB178\uD53C\uC624 \uAD6C\uCD9C \uB300\uC791\uC804");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setBackground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("굴림", Font.BOLD, 60));
		titleLabel.setBounds(113, 109, 606, 80);
		contentPane.add(titleLabel);
		
		scenario = new JTextPane();
		scenario.setFont(new Font("굴림", Font.PLAIN, 20));
		scenario.setText("\uD0A4\uB178\uD53C\uC624\uAC00 \uCFE0\uD30C\uC5D0\uAC8C \uB0A9\uCE58\uB2F9\uD588\uB2E4! \uCFE0\uD30C\uC640\uC758 \uB300\uACB0\uC5D0\uC11C \uC2B9\uB9AC\uD574\uC11C \uCFE0\uD30C\uC758 \uC131\uC5D0 \uAC07\uD600\uC788\uB294 \uD0A4\uB178\uD53C\uC624\uB97C \uAD6C\uCD9C\uD558\uC790!");
		scenario.setBounds(127, 248, 577, 59);
		contentPane.add(scenario);
		bg=new JLabel("bg img"); 
		bg.setBounds(0,0,825,518); 
		bg.setIcon(m3);	
		
		contentPane.add(bg);
		
	}
}
