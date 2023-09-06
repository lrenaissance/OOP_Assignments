package weapon;

import interfaces.Attackable;
import player.Player;

public class Weapon implements Attackable {
    private int power;

    public int getPower(){
        return this.power;
    }

    public void setPower(int power){
    	this.power=power;
    }

	public void attack(Player me,Player target) {
		// TODO Auto-generated method stub
		System.out.println(me.getName()+"��(��) "+target.getName()+"��(��) �����մϴ�.");
	}
 
}
