package player;

import weapon.*;

public class ���� extends Player {

    public ����(){
    	this.setName("����");
    	System.out.println("Bwah hah hah!");
    	this.setInit_hp(400);
    	this.setHp(this.getInit_hp());
    	this.setPower(40);
    	this.setWeapon(new ChainChomp());
    }

    public void attack(Player target){//������ �⺻����(basic attack)
    	�һձ�();
    	target.setHp(target.getHp()-this.getPower());
    	System.out.println(target.getName()+"�� ���� ����:");
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"�� ���������ϴ�!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void �һձ�(){
    	System.out.println(this.getName()+"�� ���� �ս��ϴ�!");
    }

}
