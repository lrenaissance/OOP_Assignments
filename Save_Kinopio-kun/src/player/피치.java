package player;

import weapon.*;

public class ��ġ extends Player {
	
	private static ��ġ instance=null;
	
    private ��ġ(){
    	this.setName("��ġ");
    	System.out.println("I am a princess~");
    	this.setInit_hp(150);
    	this.setHp(this.getInit_hp());
    	this.setWeapon(new BabyPeach());
    }
    
    public static ��ġ getInstance() {
    	if(instance==null) {
    		instance=new ��ġ();
    	}
    	else {
    		System.out.println("��ġ�� ������ �� �����.");
    	}
    	return instance;
    }

    public void attack(Player target){
    	if(this.getHp()==this.getInit_hp()) {
    		System.out.println("��ġ�� ���� ���ذ� �����! �ݻ縦 �� �� �����ϴ�.");
    		return;
    	}
    	�ݻ��ϱ�(target);
    	target.setHp(target.getHp()-this.getPower());
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"�� ���������ϴ�!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void �ݻ��ϱ�(Player target){
    	System.out.println(this.getName()+"�� ������ �ݻ��ؼ� ������ �״�� �����ݴϴ�!");
    	this.setPower((int)(target.getPower()*Math.random()));
    	target.setHp(target.getHp()-this.getPower());//���� ���� �ݻ��ϱ�(reflects an enemy's attack)
    }

}
