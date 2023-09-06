package player;

import weapon.*;

public class 피치 extends Player {
	
	private static 피치 instance=null;
	
    private 피치(){
    	this.setName("피치");
    	System.out.println("I am a princess~");
    	this.setInit_hp(150);
    	this.setHp(this.getInit_hp());
    	this.setWeapon(new BabyPeach());
    }
    
    public static 피치 getInstance() {
    	if(instance==null) {
    		instance=new 피치();
    	}
    	else {
    		System.out.println("피치는 선택할 수 없어요.");
    	}
    	return instance;
    }

    public void attack(Player target){
    	if(this.getHp()==this.getInit_hp()) {
    		System.out.println("피치가 받은 피해가 없어요! 반사를 할 수 없습니다.");
    		return;
    	}
    	반사하기(target);
    	target.setHp(target.getHp()-this.getPower());
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"가 쓰러졌습니다!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void 반사하기(Player target){
    	System.out.println(this.getName()+"가 공격을 반사해서 적에게 그대로 돌려줍니다!");
    	this.setPower((int)(target.getPower()*Math.random()));
    	target.setHp(target.getHp()-this.getPower());//상대방 공격 반사하기(reflects an enemy's attack)
    }

}
