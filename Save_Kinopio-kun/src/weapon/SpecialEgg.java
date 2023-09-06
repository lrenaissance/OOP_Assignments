package weapon;

import interfaces.Throwable;
import player.Player;

public class SpecialEgg extends Weapon implements Throwable {
	
    public SpecialEgg(){
    	System.out.println("요시가 비장의 무기 스페셜 에그를 꺼냈습니다!");
    }

    public void swallow(){
    	System.out.println("요시가 상대방의 power를 삼켜버렸습니다.");
    }

    public int swallow_throw(Player me, Player target){
    	swallow();
    	System.out.println("삼킨 power는 요시의 스페셜 에그에 저장되었습니다.");
    	int eggPower=me.getPower()+target.getPower();
    	throw_it();
    	return eggPower;
    }

	public void throw_it() {
		System.out.println("요시가 스페셜 에그를 쿠파에게 던져버립니다.");
	}
    
	public void attack(Player me,Player target) {
		int eggPower=swallow_throw(me,target);
		target.setHp(target.getHp()-eggPower);
		System.out.println(target.getName()+"의 현재 상태:");
    	System.out.println("hp: "+target.getHp());
	}

}
