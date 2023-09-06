package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import player.*;
import weapon.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class BattleView extends JFrame {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JProgressBar bar1;
	private JLabel label2;
	private JProgressBar bar2;
	private JLabel nameLabel1;
	private JLabel nameLabel2;
	private JLabel kinoLabel;
	private JLabel label1;
	private JButton btn4;
	private JButton btn3;
	private JButton toChoosePlayer;
	private JLabel weaponLabel1;
	private JLabel weaponLabel2;
	private JTextArea textArea;
	private JLabel bgBattle;
	
	Player p1=new Player();
	Player p2=new Player();
	public static int isEnd=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleView frame = new BattleView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void show(Player player1, Player player2) {
		try {
			textArea.append("===========================================\n");
			textArea.append(player1.getName()+"�� ���� ����:\n");
			if(player1.getHp()<=0) {
				textArea.append(player1.getName()+"�� ���������ϴ�.\n");
			}
			else {
				textArea.append("hp: "+player1.getHp());
				textArea.append("\n\n");	
			}
			if(player2.getHp()<=0) {
				textArea.append(player2.getName()+"�� ���������ϴ�.");
			}
			else {
				textArea.append(player2.getName()+"�� ���� ����:\n");
				textArea.append("hp: "+player2.getHp());
				textArea.append("\n\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public BattleView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Ű���ǿ� ���� ������");
		setContentPane(contentPane);
		
		Image m1=new ImageIcon(this.getClass().getResource("/img/castle.png")).getImage(); Image
		m2=m1.getScaledInstance(this.getSize().width,this.getSize().height,Image.SCALE_SMOOTH); ImageIcon m3=new ImageIcon(m2);

		bgBattle=new JLabel("bg img"); 
		bgBattle.setBounds(0,0,825, 518); 
		bgBattle.setIcon(m3);
		
		
		btn1 = new JButton("�����ϱ�");
		btn1.setBounds(24, 354, 126, 60);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//������� ����(the rescue team's turn)
				p1.attack(p2);//�⺻����(basic attack)
				textArea.append(p1.getName()+"�� "+p2.getName()+"�� �����մϴ�.\n");
				bar2.setValue(p2.getHp());
				show(p1,p2);
				System.out.println("cnt:"+choosePlayer.cnt);
				if(p1.getName()=="������") {
					weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/����ǥ����.png")));
					label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/mario.png")));	
				}
				
				if (p2.getHp() <= 0) {//���� ����(if the enemy dies)
					kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/happykino.png")));
					textArea.append("Ű���ǿ� ������� �¸�!\n");
	            	JOptionPane.showMessageDialog(null, "Ű���ǿ� ������� �¸�! Ű���ǿ��� ������ ������ ������ �����Ǿ����ϴ�. ���ư���, �����ձ�����!!\n");
	            	btn1.setEnabled(false);
	            	btn2.setEnabled(false);
	            	btn3.setEnabled(false);
	            	btn4.setEnabled(false);
	            	isEnd=1;
	            	toChoosePlayer.setText("�����ϱ�");
	        
	            	toChoosePlayer.setEnabled(true);
                }
 
			}
		});
		contentPane.setLayout(null);
		
		weaponLabel1 = new JLabel("Weapon1");
		weaponLabel1.setBounds(22, 243, 82, 101);
		weaponLabel1.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(weaponLabel1);
		
		toChoosePlayer = new JButton("\uB2E4\uC74C \uCC28\uB840\uB85C");
		toChoosePlayer.setFont(new Font("����", Font.PLAIN, 11));
		toChoosePlayer.setEnabled(false);
		toChoosePlayer.setBounds(365, 30, 93, 23);
		contentPane.add(toChoosePlayer);
		contentPane.add(btn1);
		toChoosePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//������� ����(the rescue team's turn)
				dispose();
				if(isEnd==1) {
					System.exit(1);
				}
			}
		});
		
		btn2 = new JButton("\uC544\uC774\uD15C \uC0AC\uC6A9\uD558\uAE30");
		btn2.setBounds(160, 354, 126, 60);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//������� �����۾���(the rescue team's turn with a special item)
				System.out.println("cnt:"+choosePlayer.cnt);
				p1.getWeapon().attack(p1,p2);//������ ���� //attack with a special item
				
				if(p1.getName()=="��ġ") {
					textArea.append("��ġ�� ������ ����, ���̺� ��ġ ��ȯ!\n");
					if(((BabyPeach)p1.getWeapon()).cnt<=0){
						textArea.append("���̺� ��ġ ��ȯ Ƚ���� �� ����Ⱦ��.\n");
						btn2.setEnabled(false);
					}
					else {
						textArea.append("��ġ�� ���̺� ��ġ�� �������� ������ �� ü���� ȸ���մϴ�.\n");
					}
				}
				
				if(p1.getName()=="���") {
					textArea.append("����� ����Ⱦ��̿���!\n");
					textArea.append("��ð� ����Ⱦ˿� ���� ������ ������ �� �����ϴ�!\n");
				}
				
				if(p1.getName()=="������") {
					
					if(((QuestionMarkBlock)p1.getWeapon()).cnt<=0) {
						textArea.append("����ǥ���ڸ� �� ����Ⱦ��.\n");
						btn2.setEnabled(false);
					}
					
					//�����ۺ� �̹��� ����(img changes as the item changes)
					else if(((QuestionMarkBlock)p1.getWeapon()).type==0) { //���۹���(super mushroom)
						textArea.append("�������� ����ǥ���ڿ��� ���۹����� ������ϴ�!\n");
						textArea.append("�������� ���۹����� �԰� ��ȭ�Ͽ� ���� �����մϴ�.\n");
						weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/supermush.png")));
						label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/superMario.png")));
					}
					else if(((QuestionMarkBlock)p1.getWeapon()).type==1) { //ü�¾�����(one up mushroom)
						textArea.append("�������� ����ǥ���ڿ��� ü�¾������� ������ϴ�!\n");
						textArea.append("�������� ü�¾��������� ü���� ȸ���մϴ�.\n");
						weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/1upmush.png")));
						label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/1upMario.png")));
					}
					else if(((QuestionMarkBlock)p1.getWeapon()).type==2) { //�ظӽ�Ʈ(hammer suit)
						textArea.append("�������� ����ǥ���ڿ��� �ظӽ�Ʈ�� ������ϴ�!\n");
						textArea.append("�������� �ظӸ� ������ �����ϴ�!\n");
						weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/hammer.png")));
						label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/hammerMario.png")));
					}
					
				}
				
				
				
				if(p1.getName()=="��ġ"||(p1.getName()=="������"&&((QuestionMarkBlock)p1.getWeapon()).type==1)){
					bar1.setValue(p1.getHp());
				}
				else {
					bar2.setValue(p2.getHp());
				}
				show(p1,p2);
				
				if (p2.getHp() <= 0) {//���� ����(if the enemy dies)
					kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/happykino.png")));
					btn1.setEnabled(false);
	            	btn2.setEnabled(false);
	            	btn3.setEnabled(false);
	            	btn4.setEnabled(false);
					textArea.append("Ű���ǿ� ������� �¸�!\n");
	            	JOptionPane.showMessageDialog(null, "Ű���ǿ� ������� �¸�! Ű���ǿ��� ������ ������ ������ �����Ǿ����ϴ�. ���ư���, �����ձ�����!!\n");
	            	isEnd=1;
	            	toChoosePlayer.setText("�����ϱ�");
	            	
	            	toChoosePlayer.setEnabled(true);
                }

			}
		});
		contentPane.add(btn2);
		
		bar1 = new JProgressBar();
		bar1.setBounds(24, 30, 262, 29);
		//bar1.setValue(100);
		bar1.setForeground(new Color(51, 204, 51));
		contentPane.add(bar1);
		
		label1 = new JLabel("");
		label1.setBounds(78, 69, 202, 275);
		contentPane.add(label1);
		
		btn3 = new JButton("\uACF5\uACA9\uD558\uAE30");
		btn3.setBounds(541, 354, 126, 60);
		contentPane.add(btn3);
		btn3.addActionListener(new ActionListener() { //������ ����(Bowser's attack)
			public void actionPerformed(ActionEvent e) {
				System.out.println("cnt:"+choosePlayer.cnt);
				//p1.attack();
				p2.attack(p1);//�⺻����(basic attack)
				textArea.append(p2.getName()+"�� "+p1.getName()+"�� �����մϴ�.\n");
				bar1.setValue(p1.getHp());
				show(p1,p2);
				
				if (p1.getHp()<= 0) {//���� ����(if the enemy dies)
					if(choosePlayer.cnt>0) {//���� ������ ��������(survivors left in the rescue team)
						btn1.setEnabled(false);
		            	btn2.setEnabled(false);
		            	btn3.setEnabled(false);
		            	btn4.setEnabled(false);
					}
					else {
						kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/sadkino.png")));
						btn1.setEnabled(false);
		            	btn2.setEnabled(false);
		            	btn3.setEnabled(false);
		            	btn4.setEnabled(false);
						textArea.append("������ �¸�!\n");
		            	JOptionPane.showMessageDialog(null, "������ �¸�! Ű���ǿ��� ������ ������ ������ ��Եɰž�!!!\n");
		            	toChoosePlayer.setText("�����ϱ�");
		            	isEnd=1;
					}
					toChoosePlayer.setEnabled(true);
                }
				
			}
		});
		
		btn4 = new JButton("\uC544\uC774\uD15C \uC0AC\uC6A9\uD558\uAE30");
		btn4.setBounds(677, 354, 126, 60);
		contentPane.add(btn4);
		btn4.addActionListener(new ActionListener() { //������ ������(Bowser's item)
			public void actionPerformed(ActionEvent e) {
				System.out.println("cnt:"+choosePlayer.cnt);
			
				if(((ChainChomp)p2.getWeapon()).cnt<=0){
					textArea.append("�۸��̰� ���� �����Ⱦ��.\n");
					btn4.setEnabled(false);
				}
				else {
					textArea.append("���İ� �۸��̸� ��ȯ�մϴ�!\n");
					textArea.append("���İ� �۸��̸� �ֵθ��ϴ�!\n");
				}
	
				
				p2.getWeapon().attack(p2,p1);//������ ����(attack with a special item)
				bar1.setValue(p1.getHp());
				show(p1,p2);
			
				
				if (p1.getHp() <= 0) {//���� ����(if the enemy dies)
					if(choosePlayer.cnt>0) {//���� ������ ��������(survivors in the rescue team)
						btn1.setEnabled(false);
		            	btn2.setEnabled(false);
		            	btn3.setEnabled(false);
		            	btn4.setEnabled(false);
					}
					else {
						kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/sadkino.png")));
						textArea.append("������ �¸�!\n");
						btn1.setEnabled(false);
		            	btn2.setEnabled(false);
		            	btn3.setEnabled(false);
		            	btn4.setEnabled(false);
		            	JOptionPane.showMessageDialog(null, "������ �¸�! Ű���ǿ��� ������ ������ ������ ��Եɰž�!!!\n");
		            	toChoosePlayer.setText("�����ϱ�");
		            	isEnd=1;
					}
					toChoosePlayer.setEnabled(true);
                }
				
			}
		});

		
		label2 = new JLabel("New label");
		label2.setBounds(541, 69, 202, 275);
		label2.setIcon(new ImageIcon(BattleView.class.getResource("/img/\uCFE01.png")));
		contentPane.add(label2);
		
		bar2 = new JProgressBar();
		bar2.setBounds(541, 30, 262, 29);
		//bar2.setValue(100);
		bar2.setForeground(new Color(51, 204, 51));
		contentPane.add(bar2);
		
		nameLabel1 = new JLabel("\uB9C8\uB9AC\uC624");
		nameLabel1.setForeground(new Color(255, 255, 255));
		nameLabel1.setBounds(109, 424, 90, 35);
		nameLabel1.setFont(new Font("����", Font.PLAIN, 30));
		contentPane.add(nameLabel1);
		
		nameLabel2 = new JLabel("\uCFE0\uD30C");
		nameLabel2.setForeground(new Color(255, 255, 255));
		nameLabel2.setBounds(643, 424, 67, 35);
		nameLabel2.setFont(new Font("����", Font.PLAIN, 30));
		contentPane.add(nameLabel2);
		
		kinoLabel = new JLabel("New label");
		kinoLabel.setBounds(339, 10, 144, 160);
		kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/jail.png")));
		contentPane.add(kinoLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 170, 240, 303);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		weaponLabel2 = new JLabel("Weapon2");
		weaponLabel2.setBounds(721, 243, 82, 101);
		weaponLabel2.setIcon(new ImageIcon(BattleView.class.getResource("/img/�۸���.png")));
		weaponLabel2.setBackground(Color.WHITE);
		contentPane.add(weaponLabel2);
		
		contentPane.add(bgBattle);
	}

	public BattleView(Player hero,Player bowser) {
		this();
		p1=hero;
		p2=(����)bowser;
		
		bar1.setMaximum(p1.getInit_hp());
		bar1.setValue(p1.getHp());
		bar2.setMaximum(p2.getInit_hp());
		bar2.setValue(p2.getHp());
		
		String heroType=p1.getClass().getSimpleName();
		
		switch(heroType) {
			case "������":
				label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/mario.png")));
				weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/����ǥ����.png")));
				nameLabel1.setText("������");
				textArea.append("���� ������! Ű���ǿ��� ������!\n");
				textArea.append("It's-a-me! Mario!\n");
				break;
			case "��ġ":
				label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/��ġ.png")));
				weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/���̺���ġ.png")));
				nameLabel1.setText("��ġ");
				textArea.append("���� ��ġ! Ű���ǿ��� ������!\n");
				textArea.append("I am a princess~\n");
				break;
			case "���":
				label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/���.png")));
				weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/��þ�.png")));
				nameLabel1.setText("���");
				textArea.append("���� ���! Ű���ǿ��� ������!\n");
				textArea.append("Yoshi~!");
				break;
		}
	}
}
