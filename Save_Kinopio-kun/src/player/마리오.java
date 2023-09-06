package player;

import weapon.*;

public class 마리오 extends Player {
	private static 마리오 instance=null;

    private 마리오(){
    	this.setName("마리오");
    	System.out.println("It's-a-me! Mario!");
    	this.setInit_hp(200);
    	this.setHp(this.getInit_hp());
    	this.setPower(30);
    	this.setWeapon(new QuestionMarkBlock());
    }
    
    public static 마리오 getInstance() {
    	if(instance==null) {
    		instance=new 마리오();
    	}
    	else {
    		System.out.println("마리오는 선택할 수 없어요.");
    	}
    	return instance;
    }

    public void attack(Player target){//기본공격(basic attack)
    	점프하기();
    	target.setHp(target.getHp()-this.getPower());
    	System.out.println(target.getName()+"의 현재 상태:");
    	if(target.getHp()<=0) {
    		System.out.println(target.getName()+"가 쓰러졌습니다!");
    	}
    	else {
    		System.out.println("hp: "+target.getHp());	
    	}
    }

    public void 점프하기(){//jumping attack
    	System.out.println(this.getName()+"가 점프해서 적의 머리를 눌러버립니다!");
    }

    public void 상자열기(){//opening the box
    	System.out.println(this.getName()+"의 비장의 무기 등장!");
    	System.out.println("물음표 상자를 엽니다! 뭐가 나올까요??");
    }
    
    public void useItem(Weapon weapon,Player target){
    	상자열기();
    	weapon.attack(this, target);
    }

}
