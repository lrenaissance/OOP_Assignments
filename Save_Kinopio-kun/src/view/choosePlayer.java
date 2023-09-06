package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import player.*;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class choosePlayer extends JFrame {

	private JPanel contentPane;
	private JTextField textTitle;
	private JTextField txtHp1;
	private JTextField txtPower1;
	private JTextField textField1;
	private JTextField textField1_1;
	private JLabel label1_1;
	private JTextField txtHp2;
	private JTextField txtPower2;
	private JTextField textField2;
	private JTextField textField2_1;
	private JButton btnPeach;
	private JLabel label1_2;
	private JTextField textHp3;
	private JTextField txtPower3;
	private JTextField textField3;
	private JTextField textField3_1;
	private JButton btnYoshi;
	private JLabel bg;//background
	

	Player p1;
	ÄíÆÄ p2=new ÄíÆÄ();
	public static int cnt=3;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choosePlayer frame = new choosePlayer();
					frame.setVisible(true);
					if(choosePlayer.cnt<=0) {
						frame.dispose();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public choosePlayer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 518);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		this.setTitle("Å°³ëÇÇ¿À ±¸Ãâ ´ëÀÛÀü");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Image m1=new ImageIcon(this.getClass().getResource("/img/mush.png")).getImage(); Image
		m2=m1.getScaledInstance(this.getSize().width,this.getSize().height,Image.SCALE_SMOOTH); ImageIcon m3=new ImageIcon(m2);

		bg=new JLabel("bg img"); bg.setBounds(0,0,825, 518); bg.setIcon(m3);		
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		textTitle.setHorizontalAlignment(SwingConstants.CENTER);
		textTitle.setBounds(307, 10, 176, 40);
		textTitle.setText("\uD50C\uB808\uC774\uC5B4 \uC120\uD0DD\uD558\uAE30");
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		JLabel label1 = new JLabel("New label");
		label1.setIcon(new ImageIcon(choosePlayer.class.getResource("/img/mario.png")));
		label1.setBounds(41, 46, 202, 275);
		contentPane.add(label1);
		
		txtHp1 = new JTextField();
		txtHp1.setHorizontalAlignment(SwingConstants.CENTER);
		txtHp1.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		txtHp1.setText("HP: 200");
		txtHp1.setBounds(41, 331, 84, 32);
		contentPane.add(txtHp1);
		txtHp1.setColumns(10);
		
		txtPower1 = new JTextField();
		txtPower1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPower1.setText("POWER: 30");
		txtPower1.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		txtPower1.setColumns(10);
		txtPower1.setBounds(135, 331, 108, 32);
		contentPane.add(txtPower1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		textField1.setText("\uAE30\uBCF8 \uACF5\uACA9: \uC810\uD504\uD558\uAE30");
		textField1.setBounds(41, 373, 202, 28);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField1_1 = new JTextField();
		textField1_1.setText("\uC544\uC774\uD15C: \uBB3C\uC74C\uD45C \uC0C1\uC790");
		textField1_1.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		textField1_1.setColumns(10);
		textField1_1.setBounds(41, 411, 202, 28);
		contentPane.add(textField1_1);
		
		JButton btnMario = new JButton("\uB9C8\uB9AC\uC624");
		btnMario.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		btnMario.setBounds(79, 449, 108, 26);
		btnMario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1=¸¶¸®¿À.getInstance();//»ý¼º
				if(p1!=null) {
					btnMario.setVisible(false);
					BattleView bv=new BattleView(p1,p2);
					bv.setVisible(true);
					//choosePlayer().setVisible(true);
					
					if(choosePlayer.cnt<=0||BattleView.isEnd==1) {
						dispose();
					}
					
					choosePlayer.cnt--;
				}
			}
		});
		contentPane.add(btnMario);
		
		label1_1 = new JLabel("New label");
		label1_1.setIcon(new ImageIcon(choosePlayer.class.getResource("/img/\uD53C\uCE58.png")));
		label1_1.setBounds(329, 46, 202, 275);
		contentPane.add(label1_1);
		
		txtHp2 = new JTextField();
		txtHp2.setText("HP: 150");
		txtHp2.setHorizontalAlignment(SwingConstants.CENTER);
		txtHp2.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		txtHp2.setColumns(10);
		txtHp2.setBounds(329, 331, 84, 32);
		contentPane.add(txtHp2);
		
		txtPower2 = new JTextField();
		txtPower2.setText("POWER: ?");
		txtPower2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPower2.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		txtPower2.setColumns(10);
		txtPower2.setBounds(423, 331, 108, 32);
		contentPane.add(txtPower2);
		
		textField2 = new JTextField();
		textField2.setText("\uAE30\uBCF8 \uACF5\uACA9: \uBC18\uC0AC\uD558\uAE30");
		textField2.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		textField2.setColumns(10);
		textField2.setBounds(329, 373, 202, 28);
		contentPane.add(textField2);
		
		textField2_1 = new JTextField();
		textField2_1.setText("\uC544\uC774\uD15C: \uBCA0\uC774\uBE44 \uD53C\uCE58");
		textField2_1.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		textField2_1.setColumns(10);
		textField2_1.setBounds(329, 411, 202, 28);
		contentPane.add(textField2_1);
		
		btnPeach = new JButton("\uD53C\uCE58");
		btnPeach.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		btnPeach.setBounds(367, 449, 108, 26);
		btnPeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1=ÇÇÄ¡.getInstance();//»ý¼º
				btnPeach.setVisible(false);
				if(p1!=null) {
					btnPeach.setVisible(false);
					BattleView bv=new BattleView(p1,p2);
					bv.setVisible(true);
					
					if(choosePlayer.cnt<=0||BattleView.isEnd==1) {
						dispose();
					}
					
					choosePlayer.cnt--;
				}
			}
		});
		contentPane.add(btnPeach);
		
		label1_2 = new JLabel("");
		label1_2.setIcon(new ImageIcon(choosePlayer.class.getResource("/img/\uC694\uC2DC.png")));
		label1_2.setBounds(601, 46, 202, 275);
		contentPane.add(label1_2);
		
		textHp3 = new JTextField();
		textHp3.setText("HP: 150");
		textHp3.setHorizontalAlignment(SwingConstants.CENTER);
		textHp3.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		textHp3.setColumns(10);
		textHp3.setBounds(601, 331, 84, 32);
		contentPane.add(textHp3);
		
		txtPower3 = new JTextField();
		txtPower3.setText("POWER: 35");
		txtPower3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPower3.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		txtPower3.setColumns(10);
		txtPower3.setBounds(695, 331, 108, 32);
		contentPane.add(txtPower3);
		
		textField3 = new JTextField();
		textField3.setText("\uAE30\uBCF8 \uACF5\uACA9: \uB358\uC9C0\uAE30");
		textField3.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		textField3.setColumns(10);
		textField3.setBounds(601, 373, 202, 28);
		contentPane.add(textField3);
		
		textField3_1 = new JTextField();
		textField3_1.setText("\uC544\uC774\uD15C: \uC2A4\uD398\uC15C \uC5D0\uADF8");
		textField3_1.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		textField3_1.setColumns(10);
		textField3_1.setBounds(601, 411, 202, 28);
		contentPane.add(textField3_1);
		
		btnYoshi = new JButton("\uC694\uC2DC");
		btnYoshi.setFont(new Font("³ª´®°íµñ", Font.BOLD, 18));
		btnYoshi.setBounds(639, 449, 108, 26);
		contentPane.add(btnYoshi);
		
		btnYoshi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1=¿ä½Ã.getInstance();
				btnYoshi.setVisible(false);
				if(p1!=null) {
					btnYoshi.setVisible(false);
					BattleView bv=new BattleView(p1,p2);
					bv.setVisible(true);
			
					if(choosePlayer.cnt<=0||BattleView.isEnd==1){
						dispose();
					}
					
					choosePlayer.cnt--;
				}
			}
		});
		
		contentPane.add(bg);
		
	}
}
