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
			textArea.append(player1.getName()+"의 현재 상태:\n");
			if(player1.getHp()<=0) {
				textArea.append(player1.getName()+"가 쓰러졌습니다.\n");
			}
			else {
				textArea.append("hp: "+player1.getHp());
				textArea.append("\n\n");	
			}
			if(player2.getHp()<=0) {
				textArea.append(player2.getName()+"가 쓰러졌습니다.");
			}
			else {
				textArea.append(player2.getName()+"의 현재 상태:\n");
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
		this.setTitle("키노피오 구출 대작전");
		setContentPane(contentPane);
		
		Image m1=new ImageIcon(this.getClass().getResource("/img/castle.png")).getImage(); Image
		m2=m1.getScaledInstance(this.getSize().width,this.getSize().height,Image.SCALE_SMOOTH); ImageIcon m3=new ImageIcon(m2);

		bgBattle=new JLabel("bg img"); 
		bgBattle.setBounds(0,0,825, 518); 
		bgBattle.setIcon(m3);
		
		
		btn1 = new JButton("공격하기");
		btn1.setBounds(24, 354, 126, 60);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//구출대의 공격(the rescue team's turn)
				p1.attack(p2);//기본공격(basic attack)
				textArea.append(p1.getName()+"가 "+p2.getName()+"를 공격합니다.\n");
				bar2.setValue(p2.getHp());
				show(p1,p2);
				System.out.println("cnt:"+choosePlayer.cnt);
				if(p1.getName()=="마리오") {
					weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/물음표상자.png")));
					label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/mario.png")));	
				}
				
				if (p2.getHp() <= 0) {//상대방 죽음(if the enemy dies)
					kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/happykino.png")));
					textArea.append("키노피오 구출대의 승리!\n");
	            	JOptionPane.showMessageDialog(null, "키노피오 구출대의 승리! 키노피오는 쿠파의 성에서 무사히 구조되었습니다. 돌아가자, 버섯왕국으로!!\n");
	            	btn1.setEnabled(false);
	            	btn2.setEnabled(false);
	            	btn3.setEnabled(false);
	            	btn4.setEnabled(false);
	            	isEnd=1;
	            	toChoosePlayer.setText("종료하기");
	        
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
		toChoosePlayer.setFont(new Font("굴림", Font.PLAIN, 11));
		toChoosePlayer.setEnabled(false);
		toChoosePlayer.setBounds(365, 30, 93, 23);
		contentPane.add(toChoosePlayer);
		contentPane.add(btn1);
		toChoosePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//구출대의 공격(the rescue team's turn)
				dispose();
				if(isEnd==1) {
					System.exit(1);
				}
			}
		});
		
		btn2 = new JButton("\uC544\uC774\uD15C \uC0AC\uC6A9\uD558\uAE30");
		btn2.setBounds(160, 354, 126, 60);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//구출대의 아이템쓰기(the rescue team's turn with a special item)
				System.out.println("cnt:"+choosePlayer.cnt);
				p1.getWeapon().attack(p1,p2);//아이템 공격 //attack with a special item
				
				if(p1.getName()=="피치") {
					textArea.append("피치의 비장의 무기, 베이비 피치 소환!\n");
					if(((BabyPeach)p1.getWeapon()).cnt<=0){
						textArea.append("베이비 피치 소환 횟수를 다 써버렸어요.\n");
						btn2.setEnabled(false);
					}
					else {
						textArea.append("피치가 베이비 피치의 도움으로 변신한 후 체력을 회복합니다.\n");
					}
				}
				
				if(p1.getName()=="요시") {
					textArea.append("요시의 스페셜알이에요!\n");
					textArea.append("요시가 스페셜알에 적의 공격을 저장한 후 던집니다!\n");
				}
				
				if(p1.getName()=="마리오") {
					
					if(((QuestionMarkBlock)p1.getWeapon()).cnt<=0) {
						textArea.append("물음표상자를 다 써버렸어요.\n");
						btn2.setEnabled(false);
					}
					
					//아이템별 이미지 변경(img changes as the item changes)
					else if(((QuestionMarkBlock)p1.getWeapon()).type==0) { //슈퍼버섯(super mushroom)
						textArea.append("마리오가 물음표상자에서 슈퍼버섯을 얻었습니다!\n");
						textArea.append("마리오가 슈퍼버섯을 먹고 진화하여 적을 공격합니다.\n");
						weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/supermush.png")));
						label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/superMario.png")));
					}
					else if(((QuestionMarkBlock)p1.getWeapon()).type==1) { //체력업버섯(one up mushroom)
						textArea.append("마리오가 물음표상자에서 체력업버섯을 얻었습니다!\n");
						textArea.append("마리오가 체력업버섯으로 체력을 회복합니다.\n");
						weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/1upmush.png")));
						label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/1upMario.png")));
					}
					else if(((QuestionMarkBlock)p1.getWeapon()).type==2) { //해머슈트(hammer suit)
						textArea.append("마리오가 물음표상자에서 해머슈트를 얻었습니다!\n");
						textArea.append("마리오가 해머를 적에게 던집니다!\n");
						weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/hammer.png")));
						label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/hammerMario.png")));
					}
					
				}
				
				
				
				if(p1.getName()=="피치"||(p1.getName()=="마리오"&&((QuestionMarkBlock)p1.getWeapon()).type==1)){
					bar1.setValue(p1.getHp());
				}
				else {
					bar2.setValue(p2.getHp());
				}
				show(p1,p2);
				
				if (p2.getHp() <= 0) {//상대방 죽음(if the enemy dies)
					kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/happykino.png")));
					btn1.setEnabled(false);
	            	btn2.setEnabled(false);
	            	btn3.setEnabled(false);
	            	btn4.setEnabled(false);
					textArea.append("키노피오 구출대의 승리!\n");
	            	JOptionPane.showMessageDialog(null, "키노피오 구출대의 승리! 키노피오는 쿠파의 성에서 무사히 구조되었습니다. 돌아가자, 버섯왕국으로!!\n");
	            	isEnd=1;
	            	toChoosePlayer.setText("종료하기");
	            	
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
		btn3.addActionListener(new ActionListener() { //쿠파의 공격(Bowser's attack)
			public void actionPerformed(ActionEvent e) {
				System.out.println("cnt:"+choosePlayer.cnt);
				//p1.attack();
				p2.attack(p1);//기본공격(basic attack)
				textArea.append(p2.getName()+"가 "+p1.getName()+"를 공격합니다.\n");
				bar1.setValue(p1.getHp());
				show(p1,p2);
				
				if (p1.getHp()<= 0) {//상대방 죽음(if the enemy dies)
					if(choosePlayer.cnt>0) {//아직 구조대 남아있음(survivors left in the rescue team)
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
						textArea.append("쿠파의 승리!\n");
		            	JOptionPane.showMessageDialog(null, "쿠파의 승리! 키노피오는 쿠파의 성에서 영원히 살게될거야!!!\n");
		            	toChoosePlayer.setText("종료하기");
		            	isEnd=1;
					}
					toChoosePlayer.setEnabled(true);
                }
				
			}
		});
		
		btn4 = new JButton("\uC544\uC774\uD15C \uC0AC\uC6A9\uD558\uAE30");
		btn4.setBounds(677, 354, 126, 60);
		contentPane.add(btn4);
		btn4.addActionListener(new ActionListener() { //쿠파의 아이템(Bowser's item)
			public void actionPerformed(ActionEvent e) {
				System.out.println("cnt:"+choosePlayer.cnt);
			
				if(((ChainChomp)p2.getWeapon()).cnt<=0){
					textArea.append("멍멍이가 집에 가버렸어요.\n");
					btn4.setEnabled(false);
				}
				else {
					textArea.append("쿠파가 멍멍이를 소환합니다!\n");
					textArea.append("쿠파가 멍멍이를 휘두릅니다!\n");
				}
	
				
				p2.getWeapon().attack(p2,p1);//아이템 공격(attack with a special item)
				bar1.setValue(p1.getHp());
				show(p1,p2);
			
				
				if (p1.getHp() <= 0) {//상대방 죽음(if the enemy dies)
					if(choosePlayer.cnt>0) {//아직 구조대 남아있음(survivors in the rescue team)
						btn1.setEnabled(false);
		            	btn2.setEnabled(false);
		            	btn3.setEnabled(false);
		            	btn4.setEnabled(false);
					}
					else {
						kinoLabel.setIcon(new ImageIcon(BattleView.class.getResource("/img/sadkino.png")));
						textArea.append("쿠파의 승리!\n");
						btn1.setEnabled(false);
		            	btn2.setEnabled(false);
		            	btn3.setEnabled(false);
		            	btn4.setEnabled(false);
		            	JOptionPane.showMessageDialog(null, "쿠파의 승리! 키노피오는 쿠파의 성에서 영원히 살게될거야!!!\n");
		            	toChoosePlayer.setText("종료하기");
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
		nameLabel1.setFont(new Font("굴림", Font.PLAIN, 30));
		contentPane.add(nameLabel1);
		
		nameLabel2 = new JLabel("\uCFE0\uD30C");
		nameLabel2.setForeground(new Color(255, 255, 255));
		nameLabel2.setBounds(643, 424, 67, 35);
		nameLabel2.setFont(new Font("굴림", Font.PLAIN, 30));
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
		weaponLabel2.setIcon(new ImageIcon(BattleView.class.getResource("/img/멍멍이.png")));
		weaponLabel2.setBackground(Color.WHITE);
		contentPane.add(weaponLabel2);
		
		contentPane.add(bgBattle);
	}

	public BattleView(Player hero,Player bowser) {
		this();
		p1=hero;
		p2=(쿠파)bowser;
		
		bar1.setMaximum(p1.getInit_hp());
		bar1.setValue(p1.getHp());
		bar2.setMaximum(p2.getInit_hp());
		bar2.setValue(p2.getHp());
		
		String heroType=p1.getClass().getSimpleName();
		
		switch(heroType) {
			case "마리오":
				label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/mario.png")));
				weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/물음표상자.png")));
				nameLabel1.setText("마리오");
				textArea.append("가라 마리오! 키노피오를 구해줘!\n");
				textArea.append("It's-a-me! Mario!\n");
				break;
			case "피치":
				label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/피치.png")));
				weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/베이비피치.png")));
				nameLabel1.setText("피치");
				textArea.append("가라 피치! 키노피오를 구해줘!\n");
				textArea.append("I am a princess~\n");
				break;
			case "요시":
				label1.setIcon(new ImageIcon(BattleView.class.getResource("/img/요시.png")));
				weaponLabel1.setIcon(new ImageIcon(BattleView.class.getResource("/img/요시알.png")));
				nameLabel1.setText("요시");
				textArea.append("가라 요시! 키노피오를 구해줘!\n");
				textArea.append("Yoshi~!");
				break;
		}
	}
}
