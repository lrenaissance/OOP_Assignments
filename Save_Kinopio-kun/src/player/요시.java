package player;

import weapon.*;

public class ��� extends Player {
	private static ��� instance=null;
	
    private ���(){
    	this.setName("���");
    	System.out.println("Yoshi~!");
    	this.setInit_hp(150);
    	this.setHp(this.getInit_hp());
    	this.setPower(35);
    	this.setWeapon(new SpecialEgg());
    }
    
    public static ��� getInstance() {
    	if(instance==null) {
    		instance=new ���();
    	}
    	else {
    		System.out.println("��ô� ������ �� �����.");
    	}
    	return instance;
    }

    public void attack(Player target){//����� �⺻����(basic attack)
    	������();
    	target.setHp(target.getHp()-this.getPower());
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"�� ���������ϴ�!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void ������(){
    	System.out.println(this.getName()+"�� ������ ���� �����ϴ�!");
    }
    
}
