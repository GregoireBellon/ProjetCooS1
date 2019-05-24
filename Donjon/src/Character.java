import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that power an entity (player or not)
 * @author Gregoire 
 *
 */
public class Character {

	/**
	 * Room where the character is
	 */
	public Room room;
	
	protected String name; 
	protected int hp; //life
	protected int hp_max; //max life
	protected Dungeon place;
	
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
	public Character(String name, int hp, Weapon weapon, Dungeon place) {
		this.name = name;
		this.hp = hp;
		hp_max=hp;
		equipment_list.add(weapon);
		this.place = place;
	}
	
	/**
	 * Make the character say something
	 * @param text : What the character say
	 */
	public void speak(String text) {
		System.out.println(name+" : "+text); 
	}

	/**
	 * return health point of the character
	 * @return hp
	 */
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
	 * Display the Character's name, hps, hps max, and all the equipment
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
	
	
	/**
	 * 
	 * @param ennemy Character who attacks
	 * @param damages Damages to this character
	 * @return 0 = Character is dead
	 * @throws IOException due to the character generation
	 */
	protected int fight(Character ennemy, int damages) throws IOException {
		
		place.GetRoom(Main.hero.getPositionX(), Main.hero.getPositionY()).setIs_there_ennemy(false);
		//ennemy.room.setIs_there_ennemy(false); //if we fight : we win or die, so there is no more ennemy or no more hero (end)


		Main.skipLines();
		
		hp=hp-ennemy.getUsingWeapon().pa;
		
		System.out.println("You infliged "+damages+" to the "+name+" ! \n");
		
		System.out.println("The "+name+" could inflige you "+getUsingWeapon().pa);
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

/**
 * return name of the character
 * @return name of the character
 */
	public String getName() {
		return name;
	}

	/**
	 * return weapon that the character is using
	 * @return weapon that the character is using
	 */
	public Weapon getUsingWeapon() {
		return (Weapon) equipment_list.get(0);
	}
	
	/**
	 *return false if the character is dead 
	 * @return is the character dead?
	 */
	public boolean isDead(){
		return hp<=0;
	}
	
	/**
	 * Show the name of the character and print his life bar
	 */
	public void life() {
		System.out.println(name+"'s life : "+hp);
		printlifeBar();
	}
	
	/**
	 * print the life bar of the character
	 */
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
	
	/**
	 * Handle the fight. Display if a character is dead
	 * @param ennemy
	 * @throws IOException
	 */
	public void fightContext(Character ennemy) throws IOException {
	int result = this.fight(ennemy, 0);
	System.out.println(result);
	if(result==1) {
		System.out.println(name+" defeated "+ennemy.name);
	}
	else System.out.println(ennemy.name+" defeated "+name);

	
	Main.hero.alive=false;
	}

	
}
