package weapon;

import interfaces.Curable;
import player.Player;

public class OneUpMushroom extends Weapon implements Curable {

    public OneUpMushroom(){}

    public int self_healing(Player me){
    	double rate=Math.random();
    	while(rate<=0.4||rate>=0.6) { 
    		//베이비 피치와 다르게 체력업버섯은 깎인 hp의 40~60퍼센트만 회복할 수 있습니다.
    		//can cure only 40-60 percent of the reduced hp(different from Baby Peach)
    		rate=Math.random();
    	}
    	int cure=(int)((me.getInit_hp()-me.getHp())*rate);
    	me.setHp(cure+me.getHp());
        return me.getHp();
    }
    
    public void attack(Player me, Player target) {
    	System.out.println("체력업버섯으로는 공격할 수 없어요!");
    	System.out.println("공격 대신 자가 치유를 진행합니다.");
    	self_healing(me);
    	System.out.println(me.getName()+"의 현재 상태:");
    	System.out.println("hp: "+me.getHp());
    }
    
}
