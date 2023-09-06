package weapon;

import java.util.Arrays;
import java.util.List;

import player.Player;


public class QuestionMarkBlock extends Weapon {
	public static int cnt=3;
	public static int type=-1;
	private static List<Weapon> weapons = Arrays.asList(new SuperMushroom(), new OneUpMushroom(), new HammerSuit());
	
    public QuestionMarkBlock(){   }

    public Weapon open_the_block() {
		//�������� �� �� �ϳ�
		this.type=(int)(Math.random()*1000)%3; //0~3 ����(0-3 possible)
		this.cnt--;//���� ��� Ƚ�� ����(deducting box count)
		Weapon weapon;
		switch(this.type) {
			case 0:
				System.out.println("����ǥ ���ڿ��� ���۹����� ���Խ��ϴ�!");
				break;
			case 1:
				System.out.println("����ǥ ���ڿ��� ü�¾� ������ ���Խ��ϴ�!");
				break;
			case 2:
				System.out.println("����ǥ ���ڿ��� �ظӽ�Ʈ�� ���Խ��ϴ�!");
				System.out.println("�ظӽ�Ʈ ���� �Ϸ�!");
		    	System.out.println("�ظӸ����� ����!");
		    	break;
		}
		weapon=weapons.get(this.type);
		return weapon;
    }
    
	public void attack(Player me,Player target) {
		if(this.cnt<=0) {
    		System.out.println("���̻� �� �� �ִ� ����ǥ ���ڰ� �����!");
    		return;
    	}
	
		Weapon weapon=open_the_block();
		
		weapon.attack(me,target);
	}

}
