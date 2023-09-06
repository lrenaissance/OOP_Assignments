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
		//랜덤으로 셋 중 하나
		this.type=(int)(Math.random()*1000)%3; //0~3 가능(0-3 possible)
		this.cnt--;//상자 사용 횟수 차감(deducting box count)
		Weapon weapon;
		switch(this.type) {
			case 0:
				System.out.println("믈음표 상자에서 슈퍼버섯이 나왔습니다!");
				break;
			case 1:
				System.out.println("믈음표 상자에서 체력업 버섯이 나왔습니다!");
				break;
			case 2:
				System.out.println("믈음표 상자에서 해머슈트가 나왔습니다!");
				System.out.println("해머슈트 착용 완료!");
		    	System.out.println("해머마리오 변신!");
		    	break;
		}
		weapon=weapons.get(this.type);
		return weapon;
    }
    
	public void attack(Player me,Player target) {
		if(this.cnt<=0) {
    		System.out.println("더이상 열 수 있는 물음표 상자가 없어요!");
    		return;
    	}
	
		Weapon weapon=open_the_block();
		
		weapon.attack(me,target);
	}

}
