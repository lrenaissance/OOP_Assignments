package weapon;

import interfaces.Throwable;
import player.Player;

public class SpecialEgg extends Weapon implements Throwable {
	
    public SpecialEgg(){
    	System.out.println("��ð� ������ ���� ����� ���׸� ���½��ϴ�!");
    }

    public void swallow(){
    	System.out.println("��ð� ������ power�� ���ѹ��Ƚ��ϴ�.");
    }

    public int swallow_throw(Player me, Player target){
    	swallow();
    	System.out.println("��Ų power�� ����� ����� ���׿� ����Ǿ����ϴ�.");
    	int eggPower=me.getPower()+target.getPower();
    	throw_it();
    	return eggPower;
    }

	public void throw_it() {
		System.out.println("��ð� ����� ���׸� ���Ŀ��� ���������ϴ�.");
	}
    
	public void attack(Player me,Player target) {
		int eggPower=swallow_throw(me,target);
		target.setHp(target.getHp()-eggPower);
		System.out.println(target.getName()+"�� ���� ����:");
    	System.out.println("hp: "+target.getHp());
	}

}
