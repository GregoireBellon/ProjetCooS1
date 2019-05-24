import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCharacter extends Character {

	public Bag actual_bag; 
	Scanner sc = new Scanner(System.in);

	/**
	 * Position[0] = x, Position[1] = y
	 */
	protected int Position[] = new int[2];

	
	
	public MainCharacter(String name, int[] Position, Weapon weapon, Dungeon place, Room room) {
		super(name, 100, weapon, place);
		super.hp_max = 100;
		this.Position[0] = Position[0];
		this.Position[1] = Position[1];
		actual_bag = new Bag("Litle bag", 5);
		
	}

	/**
	 * 
	 * @return
	 */
	public boolean canAddEquipement() {
		if (equipment_list.size() < actual_bag.size) {
			return true;
		}
		return false;
	}

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
		}
		active_choice=false;
				
		return 1;
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

	@Override
	public void life() {
		System.out.println("Your life : " + hp);
		super.printlifeBar();

	}
	
	public void eraseEquipment() {
		
	}
	

	/**
	 * display the 2 position values in the terminal
	 */
	public void getPosition() {
		System.out.println("x :" + Position[0]);
		System.out.println("y :" + Position[1]);
	}

	public int getPositionX() {
		return Position[0];
	}

	public int getPositionY() {
		return Position[1];
	}

}
