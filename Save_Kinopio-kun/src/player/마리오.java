package player;

import weapon.*;

public class ������ extends Player {
	private static ������ instance=null;

    private ������(){
    	this.setName("������");
    	System.out.println("It's-a-me! Mario!");
    	this.setInit_hp(200);
    	this.setHp(this.getInit_hp());
    	this.setPower(30);
    	this.setWeapon(new QuestionMarkBlock());
    }
    
    public static ������ getInstance() {
    	if(instance==null) {
    		instance=new ������();
    	}
    	else {
    		System.out.println("�������� ������ �� �����.");
    	}
    	return instance;
    }

    public void attack(Player target){//�⺻����(basic attack)
    	�����ϱ�();
    	target.setHp(target.getHp()-this.getPower());
    	System.out.println(target.getName()+"�� ���� ����:");
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"�� ���������ϴ�!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void �����ϱ�(){//jumping attack
    	System.out.println(this.getName()+"�� �����ؼ� ���� �Ӹ��� ���������ϴ�!");
    }

    public void ���ڿ���(){//opening the box
    	System.out.println(this.getName()+"�� ������ ���� ����!");
    	System.out.println("����ǥ ���ڸ� ���ϴ�! ���� ���ñ��??");
    }
    
    public void useItem(Weapon weapon,Player target){
    	���ڿ���();
    	weapon.attack(this, target);
    }

}
