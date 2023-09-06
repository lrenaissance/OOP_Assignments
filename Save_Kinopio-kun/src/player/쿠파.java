package player;

import weapon.*;

public class 쿠파 extends Player {

    public 쿠파(){
    	this.setName("쿠파");
    	System.out.println("Bwah hah hah!");
    	this.setInit_hp(400);
    	this.setHp(this.getInit_hp());
    	this.setPower(40);
    	this.setWeapon(new ChainChomp());
    }

    public void attack(Player target){//쿠파의 기본공격(basic attack)
    	불뿜기();
    	target.setHp(target.getHp()-this.getPower());
    	System.out.println(target.getName()+"의 현재 상태:");
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"가 쓰러졌습니다!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void 불뿜기(){
    	System.out.println(this.getName()+"가 불을 뿜습니다!");
    }

}
