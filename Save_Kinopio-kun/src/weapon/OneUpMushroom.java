package weapon;

import interfaces.Curable;
import player.Player;

public class OneUpMushroom extends Weapon implements Curable {

    public OneUpMushroom(){}

    public int self_healing(Player me){
    	double rate=Math.random();
    	while(rate<=0.4||rate>=0.6) { 
    		//���̺� ��ġ�� �ٸ��� ü�¾������� ���� hp�� 40~60�ۼ�Ʈ�� ȸ���� �� �ֽ��ϴ�.
    		//can cure only 40-60 percent of the reduced hp(different from Baby Peach)
    		rate=Math.random();
    	}
    	int cure=(int)((me.getInit_hp()-me.getHp())*rate);
    	me.setHp(cure+me.getHp());
        return me.getHp();
    }
    
    public void attack(Player me, Player target) {
    	System.out.println("ü�¾��������δ� ������ �� �����!");
    	System.out.println("���� ��� �ڰ� ġ���� �����մϴ�.");
    	self_healing(me);
    	System.out.println(me.getName()+"�� ���� ����:");
    	System.out.println("hp: "+me.getHp());
    }
    
}
