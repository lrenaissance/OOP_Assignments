package weapon;

import interfaces.Curable;
import player.Player;

public class BabyPeach extends Weapon implements Curable {
    public static int cnt=3;//�ֻ�� ���Ƚ�� 3���� ����

    public BabyPeach(){
    	System.out.println("��ġ�� ������ ����, ���̺� ��ġ ����!");
    	System.out.println("���� ���� ���̺� ��ġ ��ȯ Ƚ���� "+this.cnt+"ȸ�Դϴ�.");
    }

    public int self_healing(Player me){
    	if(this.cnt<=0) {
    		System.out.println("�̷�! �̹� ���̺� ��ġ ��ȯ Ƚ���� �� ����Ⱦ��..");
    		return 0;
    	}
    	if(me.getHp()==me.getInit_hp()) {
    		return 0;
    	}
    	System.out.println("�ǻ� ��ġ�� ����!");
    	int cure=(int)((me.getInit_hp()-me.getHp())*Math.random());
    	while(cure==0) {
    		cure=(int)((me.getInit_hp()-me.getHp())*Math.random());
    	}
    	me.setHp(me.getHp()+cure); //0 �ʰ�~���� hp ���� ������ ����ŭ ġ��(can cure hp randomly from 1 to reduced hp)
    	this.cnt--;//���Ƚ�� ����(deduct the Baby Peach count)
        return me.getHp();
    }
    
    public void attack(Player me, Player target) {
    	System.out.println("���̺� ��ġ�� ������ �� �����!");
    	System.out.println("���� ��� �ڰ� ġ���� �����մϴ�.");
    	System.out.println(me.getName()+"�� ���� ����:");
    	System.out.println("hp: "+self_healing(me));
    }

}
