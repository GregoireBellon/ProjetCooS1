import java.util.ArrayList;

public class Character {

	protected String name; 
	protected int hp; //life
	protected int hp_max; //max life
	protected Dungeon place;
	
	/**
	 * List of everything the character has
	 */
	public ArrayList<Equipment> equipment_list= new ArrayList<Equipment>(); 
	
	public Character(String name, int hp, Weapon weapon, Dungeon place) {
		
		this.name = name;
		this.hp = hp;
		equipment_list.add(weapon);
		this.place = place;
		hp_max=10;
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
	
	public int fight(Character ennemy, int damages) {
		hp=hp-ennemy.getUsingWeapon().pa;
		
		System.out.println("Dammage of the "+name+" : "+getUsingWeapon().pa);
		System.out.println();
		System.out.println();
				
		if(isDead()) {
			System.out.println(name+" is dead!");
			System.out.println();
			return 0;
		}
		
		
		ennemy.fight(this, getUsingWeapon().pa);
		
	return 1;
	}

	public String getName() {
		return name;
	}
	
	public Weapon getUsingWeapon() {
		return (Weapon) equipment_list.get(0);
	}
	
	public boolean isDead(){
		return hp<=0;
	}
	
	public void life() {
		System.out.println(name+"'s life : "+hp);
		printlifeBar();
	}
	
	
	protected void printlifeBar() {
		
		System.out.println("max hp :"+hp_max);
		double coef = (double) 10*((double) hp/hp_max);
		int hash_number= (int) coef;
		String bar="";
		for(int i=0; i<hash_number;i++) {
			bar=bar+"[*]";
		}
		for(int i=0; i<10-hash_number;i++) {
			bar=bar+"[.]";
		}
		System.out.println(bar);
		System.out.println();
		System.out.println();

		
	}
	
	public void equip(Equipment equip) {
		equipment_list.add(equip); //add the equipment to the list
	}
	
	public void checkInventory() {
		int i =1;
		for(Equipment extract:equipment_list) {
			System.out.println(i+" : "+extract.toString());
			i++;
		}
	}
	
	public int fightContext(Character ennemy) {
	int result = this.fight(ennemy, 0);
	System.out.println(result);
	if(result==1) {
		System.out.println(name+" defeated "+ennemy.name);
	}
	else System.out.println(ennemy.name+" defeated "+name);

	
	return result;
	}
	
}
