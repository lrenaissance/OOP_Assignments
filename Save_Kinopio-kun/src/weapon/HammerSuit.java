package weapon;

import interfaces.Throwable;
import player.Player;

public class HammerSuit extends Weapon implements Throwable {

    public HammerSuit(){
    	this.setPower(50);
    }

	public void throw_it() {
		System.out.println("마리오가 해머를 적에게 던집니다!");
	}
	
	public void attack(Player me,Player target) {
		throw_it();
		target.setHp(target.getHp()-this.getPower());
		//해머 파워만큼 상대방 hp감소
		//reduces enemy's hp as much as the power of the hammer
		System.out.println(target.getName()+"의 현재 상태:");
    	System.out.println("hp: "+target.getHp());
	}

}
