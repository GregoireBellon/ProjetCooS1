import java.util.ArrayList;

public class Character {

	protected String name; 
	protected int hp; //life
	protected int hp_max=100; //max life
	
	/**
	 * List of everything the character has
	 */
	public ArrayList<Equipment> equipment_list= new ArrayList<Equipment>(); 
	
	public Character(String name, int hp, Weapon weapon) {
		
		this.name = name;
		this.hp = hp;
		equipment_list.add(weapon);
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

	
	@Override
	public String toString() {

		String line;
		
		line="Name : "+name+"\n";
		line=line+"Hp : "+hp+"\n";
		line=line+"Hp max : "+hp_max+"\n";
		line=line+"Equipment : \n";
		
		for(Equipment frag : equipment_list){
		
			line=line+"- "+frag.toString()+"\n";

		}
		
		return line;
	}
	
	public void interact(int damages) {};
	public void attack(int damages, Character c) {
		c.interact(damages);
	}


	
}
