package weapon;

import player.Player;

public class SuperMushroom extends Weapon {

    public SuperMushroom(){
    	this.setPower(20);
    }

    public int evolve(Player me){
    	System.out.println("마리오가 슈퍼버섯을 먹습니다.");
    	System.out.println("마리오 사이즈업! 파워가 증가합니다.");
    	int newPower=me.getPower()+this.getPower(); 
    	//슈퍼버섯을 먹으면 무기 파워만큼의 힘이 증가(eating supermush increases the force as much as the weapon power)
    	return newPower;
    }
    
    public void attack(Player me,Player target) {
    	int newPower=evolve(me);
    	target.setHp(target.getHp()-newPower);
    	System.out.println("슈퍼버섯을 먹은 마리오가 적을 공격합니다.");
    	System.out.println(target.getName()+"의 현재 상태:");
    	System.out.println("hp: "+target.getHp());
    }
}
