import java.util.ArrayList;

public class Character {

	protected String name; 
	protected int hp; //life
	protected int hp_max=100; //max life
	
	/**
	 * List of everything the character has
	 */
	public ArrayList<Equipment> equipment_list= new ArrayList<Equipment>(); 
	
	/**
	 * A character is instanced with a name, a number of hp and a weapon
	 * @param name define the name of the character
	 * @param hp define how many hp the character have
	 * @param weapon define the first weapon of the character
	 */
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
	
	/**
	 * Check how many attack point a character have based on his weapon
	 * @return
	 */
	public int getPa() {	
		Weapon arme_courante=(Weapon) equipment_list.get(0);
		return arme_courante.getPa();
	}
	
	/**
	 * Make the character lose a set number of hp
	 * @param damage How many hp are loosed by the character
	 * @return
	 */
	public boolean loseHp(int damage) { //return true if dead
		hp = hp-damage;
		
		if(hp<=0) {
			hp=0;
			return true;
		}
		return false;
	}
	
	/**
	 * Make the character get back some of his hp
	 * @param health The number of hp that are recovered by the character
	 */
	public void addHp(int health) {
		hp = hp+health;
		
		if(hp>=hp_max) {
			hp=hp_max;
		}
		return;
	}

	/**
	 * La fonction toString indique le nom du personnage, son nombre d'hp, d'hp max et une liste de son equipement
	 */
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
