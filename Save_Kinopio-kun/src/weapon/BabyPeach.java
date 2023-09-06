package weapon;

import interfaces.Curable;
import player.Player;

public class BabyPeach extends Weapon implements Curable {
    public static int cnt=3;//주사기 사용횟수 3으로 설정

    public BabyPeach(){
    	System.out.println("피치의 비장의 무기, 베이비 피치 등장!");
    	System.out.println("현재 남은 베이비 피치 소환 횟수는 "+this.cnt+"회입니다.");
    }

    public int self_healing(Player me){
    	if(this.cnt<=0) {
    		System.out.println("이런! 이미 베이비 피치 소환 횟수를 다 써버렸어요..");
    		return 0;
    	}
    	if(me.getHp()==me.getInit_hp()) {
    		return 0;
    	}
    	System.out.println("의사 피치로 변신!");
    	int cure=(int)((me.getInit_hp()-me.getHp())*Math.random());
    	while(cure==0) {
    		cure=(int)((me.getInit_hp()-me.getHp())*Math.random());
    	}
    	me.setHp(me.getHp()+cure); //0 초과~깎인 hp 이하 랜덤한 값만큼 치유(can cure hp randomly from 1 to reduced hp)
    	this.cnt--;//사용횟수 감소(deduct the Baby Peach count)
        return me.getHp();
    }
    
    public void attack(Player me, Player target) {
    	System.out.println("베이비 피치는 공격할 수 없어요!");
    	System.out.println("공격 대신 자가 치유를 진행합니다.");
    	System.out.println(me.getName()+"의 현재 상태:");
    	System.out.println("hp: "+self_healing(me));
    }

}
