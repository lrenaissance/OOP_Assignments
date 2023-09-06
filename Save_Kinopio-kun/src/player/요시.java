package player;

import weapon.*;

public class 요시 extends Player {
	private static 요시 instance=null;
	
    private 요시(){
    	this.setName("요시");
    	System.out.println("Yoshi~!");
    	this.setInit_hp(150);
    	this.setHp(this.getInit_hp());
    	this.setPower(35);
    	this.setWeapon(new SpecialEgg());
    }
    
    public static 요시 getInstance() {
    	if(instance==null) {
    		instance=new 요시();
    	}
    	else {
    		System.out.println("요시는 선택할 수 없어요.");
    	}
    	return instance;
    }

    public void attack(Player target){//요시의 기본공격(basic attack)
    	던지기();
    	target.setHp(target.getHp()-this.getPower());
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"가 쓰러졌습니다!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void 던지기(){
    	System.out.println(this.getName()+"가 적에게 알을 던집니다!");
    }
    
}
