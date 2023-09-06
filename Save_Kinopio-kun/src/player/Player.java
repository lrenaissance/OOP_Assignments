package player;

import weapon.*;
import interfaces.*;

public class Player implements Attackable, Usable {
	private int init_hp; //초기 hp값(initial hp)
    private int hp; //현 hp(current hp)
    private int power; //현 power(current power)
    private Weapon weapon;
    private String name;
    //public Player target;

    public void attack(Player target) {
    	System.out.println(target.getName()+"을 공격합니다.");
    }
    
    public void attack(Player me,Player target){
    	System.out.println(me.getName()+"이 "+target.getName()+"을 공격합니다.");
    }
    
    public void useItem(Weapon weapon,Player target){
    	weapon.attack(this, target);
    }
    
    public void setHp(int hp){
    	this.hp=hp;
    }

    public void setPower(int power){
    	this.power=power;
    }

    public int getHp(){
        return this.hp;
    }

    public int getPower(){
        return this.power;
    }

    public void setWeapon(Weapon weapon){
    	this.weapon=weapon;
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public String getName(){
        return this.name;
    }
    
    public void setName(String name) {
    	this.name=name;
    }
    
    public void useItem(Weapon weapon){
    }

	public int getInit_hp() {
		return init_hp;
	}

	public void setInit_hp(int init_hp) {
		this.init_hp = init_hp;
	}
    
}
