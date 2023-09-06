package weapon;

import player.Player;

public class SuperMushroom extends Weapon {

    public SuperMushroom(){
    	this.setPower(20);
    }

    public int evolve(Player me){
    	System.out.println("�������� ���۹����� �Խ��ϴ�.");
    	System.out.println("������ �������! �Ŀ��� �����մϴ�.");
    	int newPower=me.getPower()+this.getPower(); 
    	//���۹����� ������ ���� �Ŀ���ŭ�� ���� ����(eating supermush increases the force as much as the weapon power)
    	return newPower;
    }
    
    public void attack(Player me,Player target) {
    	int newPower=evolve(me);
    	target.setHp(target.getHp()-newPower);
    	System.out.println("���۹����� ���� �������� ���� �����մϴ�.");
    	System.out.println(target.getName()+"�� ���� ����:");
    	System.out.println("hp: "+target.getHp());
    }
}
