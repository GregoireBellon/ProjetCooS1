import java.util.ArrayList;

public class Character {
	
	
	protected String name; 
	protected int hp; //life
	
	/**
	 * List of everything the character has
	 */
	protected ArrayList<Equipment> equipment_list; 
	
	public Character(String name, int hp) {
		
		this.name = name;
		this.hp = hp;
	}
	
	/**
	 * Make the character say something
	 * @param text : What the character say
	 */
	public void Speak(String text) {
		System.out.println(name+" : "+text); 
	}
	
}
