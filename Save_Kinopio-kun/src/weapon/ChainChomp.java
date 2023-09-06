package weapon;

import player.Player;

public class ChainChomp extends Weapon {
	public static int cnt=2;
	
	public ChainChomp(){
    	System.out.println("쿠파가 멍멍이를 데려왔습니다!");
    	System.out.println("현재 남은 멍멍이 사용 횟수는 "+this.cnt+"회입니다.");
    	this.setPower(20);
    }

    public void wield(){
        System.out.println("쿠파가 멍멍이를 휘두릅니다.");
        this.cnt--;
    }

	public void attack(Player me,Player target) {
		if(this.cnt<=0) {
			System.out.println("멍멍이가 이미 집에 가버렸습니다.");
    		return;
    	}
		wield();
		target.setHp(target.getHp()-(this.getPower()+me.getPower()));
		System.out.println(target.getName()+"의 현재 상태:");
    	System.out.println("hp: "+target.getHp());
	}
	
}
