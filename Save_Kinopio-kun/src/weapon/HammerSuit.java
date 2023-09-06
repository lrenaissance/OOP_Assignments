package weapon;

import interfaces.Throwable;
import player.Player;

public class HammerSuit extends Weapon implements Throwable {

    public HammerSuit(){
    	this.setPower(50);
    }

	public void throw_it() {
		System.out.println("�������� �ظӸ� ������ �����ϴ�!");
	}
	
	public void attack(Player me,Player target) {
		throw_it();
		target.setHp(target.getHp()-this.getPower());
		//�ظ� �Ŀ���ŭ ���� hp����
		//reduces enemy's hp as much as the power of the hammer
		System.out.println(target.getName()+"�� ���� ����:");
    	System.out.println("hp: "+target.getHp());
	}

}
