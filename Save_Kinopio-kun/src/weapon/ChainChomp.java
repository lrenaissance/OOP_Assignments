package weapon;

import player.Player;

public class ChainChomp extends Weapon {
	public static int cnt=2;
	
	public ChainChomp(){
    	System.out.println("���İ� �۸��̸� �����Խ��ϴ�!");
    	System.out.println("���� ���� �۸��� ��� Ƚ���� "+this.cnt+"ȸ�Դϴ�.");
    	this.setPower(20);
    }

    public void wield(){
        System.out.println("���İ� �۸��̸� �ֵθ��ϴ�.");
        this.cnt--;
    }

	public void attack(Player me,Player target) {
		if(this.cnt<=0) {
			System.out.println("�۸��̰� �̹� ���� �����Ƚ��ϴ�.");
    		return;
    	}
		wield();
		target.setHp(target.getHp()-(this.getPower()+me.getPower()));
		System.out.println(target.getName()+"�� ���� ����:");
    	System.out.println("hp: "+target.getHp());
	}
	
}
