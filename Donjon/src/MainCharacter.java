import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

/**
 * Character that the player control.
 * @author Grégoire
 *
 */
public class MainCharacter extends Character {
	/**
	 * Is the player alive or dead?
	 */
	public boolean alive;
	
	
	public Bag actual_bag; 
	//Scanner sc = new Scanner(System.in);

	/**
	 * Position[0] = x, Position[1] = y
	 */
	protected int Position[] = new int[2];

	
	/**
	 * Generate the character
	 * @param name define the name of the player
	 * @param Position define where the player spawns
	 * @param weapon define the first weapon that the player has
	 * @param place define the dungeon where the player spawns
	 * @param room define the first room where the player spawn
	 */
	public MainCharacter(String name, int[] Position, Weapon weapon, Dungeon place, Room room) {
		super(name, 100, weapon, place);
		super.hp_max = 100;
		alive=true;
		this.Position[0] = Position[0];
		this.Position[1] = Position[1];
		actual_bag = new Bag("Litle bag", 5);
		
	}

	/**
	 * Check if the bag of the player is full or not
	 * @return true if bag isn't full
	 */
	public boolean canAddEquipement() {
		if (actual_bag.size - equipment_list.size()>0) {
			return true;
		}
		return false;
	}

	/**
	 * Allow the player to select all the choices during a fight
	 * Also handle the loss of hp and the display of informations (life)
	 *  
	 * @param ennemy Character who attacks
	 * @param damages Damages to this character
	 * @return 0 = Character is dead
	 * @throws IOException due to the character generation
	 */
	@Override
	public int fight(Character ennemy, int damages) throws IOException {
		boolean active_choice=false;
		ennemy.life();
		life();
		List<Choice> ChoiceList = new ArrayList<Choice>();

		if (damages > 0) {

			ChoiceTab take_attack = new ChoiceTab(ChoiceList);
			Choice take_hit = new Choice("Take the hit", "takeH", ennemy, this, place);
			Choice dodge = new Choice("Dodge the attack", "dodge", ennemy, this, place);
			take_attack.add(dodge);
			take_attack.add(take_hit);
			while(!active_choice) {
			active_choice=take_attack.makeChoice();
			}
			active_choice=false;
		}
		
		if(this.isDead()) {
			return 0;
		}

		Choice attack = new Choice("Attack the " + ennemy.name, "attack", ennemy, this, place);
		Choice checkI= new Choice("Check your inventory", "checkI", ennemy, this, place);
		ChoiceTab active = new ChoiceTab(attack);
		active.add(checkI);
		
		while(!active_choice) {
		active_choice=active.makeChoice();
		Main.skipLines();
		}
		active_choice=false;
				
		return 1;
	}
	
	
	
	/**
	 * Allow to select equipment to use, display all the stuff of the player with and index and let the player enter an int
	 */
	public void useTab() {
		List<Choice> choices = new ArrayList<Choice>();
		
		for(Equipment extract:equipment_list) {
			choices.add(new Choice("Use "+extract.getName(),"useO" ,this, this, Main.place, extract));
		}
		
		choices.add(new Choice("quit", "quit", this, this, Main.place));
		
		ChoiceTab tab = new ChoiceTab(choices);
		
		try {
			tab.makeChoice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Make the character move inside of a dungeon, in a specific direction (0 = north, 1 = east, 2 = south, 3 = west)
	 * @param place The dungeon, it need to be specified in order to generate new room
	 * @param direction The direction of the character while he is moving
	 * @throws IOException 
	 */
	public void move(Dungeon place, int direction) throws IOException{
		switch(direction) {
		case 0 :
			this.Position[1]--;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 1:
			this.Position[0]++;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 2:
			this.Position[1]++;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 3:
			this.Position[0]--;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		default:
			return;
		}
	}
	
	/**
	 * Compute the chances of dodging that the player has
	 * @param ennemy 
	 */
	public void dodge(Character ennemy) {
		int damages = ennemy.getUsingWeapon().pa;
		int precision = ennemy.getUsingWeapon().precision;
		
		if (Math.random() * 100 > precision) {
			System.out.println("You dodged it!");
		} else {
			System.out.println("You took the hit! (-" + ((int) damages * 1.5) + ")");
			hp = (int) (hp - damages * 1.5);
		}

		return;

	}
	
	/**
	 * Display all the equipment with characteristics
	 * Also display the bag
	 */
	public void checkInventory() {
		int i =1;
		for(Equipment extract:equipment_list) {
			System.out.println(i+" : "+extract.toString());
			i++;
		}
		System.out.println("\n \n"
				+ "Actual bag :"+actual_bag+" \n"
				+ "Remaining slots in your bag :"+(actual_bag.size-equipment_list.size()));
	}


	@Override
	public void life() {
		System.out.println("Your life : " + hp);
		super.printlifeBar();

	}
	
	/**
	 * Erase an equipment from the player's stuff
	 * @param index
	 */
	public void eraseEquipment(int index) {
		equipment_list.remove(index);
	}
	

	/**
	 * display the 2 position values in the terminal
	 */
	public void getPosition() {
		System.out.println("x :" + Position[0]);
		System.out.println("y :" + Position[1]);
	}

	/**
	 * 
	 * @return X position of the player
	 */
	public int getPositionX() {
		return Position[0];
	}

	/**
	 * 
	 * @return Y position of the player
	 */
	public int getPositionY() {
		return Position[1];
	}

}
