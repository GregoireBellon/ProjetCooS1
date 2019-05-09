import java.util.ArrayList;

public class Character {
	
	
	protected String name; 
	protected int hp; //life
	protected int hp_max; //max life
	
	
	/**
	 * List of everything the character has
	 */
	protected ArrayList<Equipment> equipment_list; 
	
	public Character(String name, int hp, Weapon weapon) {
		
		this.name = name;
		this.hp = hp;
	}
	
	/**
	 * Make the character say something
	 * @param text : What the character say
	 */
	public void speak(String text) {
		System.out.println(name+" : "+text); 
	}

	public int getHp() {
		return hp;
	}
	
	public int getPa() {
		
		Weapon arme_courante=(Weapon) equipment_list.get(0);
		return arme_courante.getPa();

	}
	
	public boolean looseHp(int damage) { //return true if dead
		hp = hp-damage;
		
		if(hp<=0) {
			hp=0;
			return true;
		}
		return false;
	}
	
	public void addHp(int health) {
		hp = hp+health;
		
		if(hp>=hp_max) {
			hp=hp_max;
		}
		return;
	}
	
}
