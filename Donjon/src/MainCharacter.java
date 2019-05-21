import java.util.Scanner;

public class MainCharacter extends Character{
	
	protected Bag actual_bag= new Bag("GROSAC", 100);
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Position[0] = x,  Position[1] = y
	 */
	protected int Position[] = new int[2];
	
	/**
	 * The main character is instanced with a name, a starting position and a starting weapon
	 * @param name The name of the character
	 * @param Position The starting position of the character
	 * @param weapon The starting weapon of the character
	 */
	public MainCharacter(String name, int[] Position, Weapon weapon) {
		super(name, 100, weapon);
		
		this.Position[0]=Position[0];
		this.Position[1]=Position[1];
		
	}
	
	/**
	 * Return true if the character have some space left in his bag
	 * @return
	 */
	public boolean canAddEquipement() {
		if(equipment_list.size()<actual_bag.size) {
			return true;
		}
		return false;
	}
		
	public void fight(int damages, Character Agresseur) {
		Equipment weapon = Agresseur.equipment_list.get(0);
		int precision = ((Weapon) weapon).getPrecision();
		boolean good_choice=false;
		int choice;
		System.out.println(Agresseur.getName()+" is attacking you! He could inflige you "+damages+" damages");
		System.out.println("What do you want to do?");
		System.out.println("1 : take the hit");
		System.out.println("2 : try to dodge ("+(100-precision)+"% of chance)");
		
		while(!good_choice) {
			choice = sc.nextInt();
		switch(choice) {
		case 1: hp = hp-damages; good_choice=true; System.out.println("You took the hit : -"+damages);
		break;
		case 2: 
			int chance= (int)Math.random()*100;
			if(chance>precision) {
				System.out.println("Hit dodged ("+chance+"%)"); //score fait par l'alea
			
			}
			else {
				System.out.println("Hit taken ("+chance+"%)");
				System.out.println("-"+damages*1.5);
				hp=(int) (hp-damages*1.5);
			}
			good_choice=true;
			break;
		default: System.out.println("Mauvais choix !"); good_choice=false;
		}
		good_choice=false;
		while(!good_choice) {
		System.out.println("Que voulez vous faire?");
		System.out.println("1 Attaquer");
		choice=sc.nextInt();
		switch(choice) {
		case 1: 
			Weapon weapon_player = (Weapon) super.equipment_list.get(0);
					Agresseur.fight(weapon_player.pa, this);		
		}
		
		
		}
	}
		
	}

	/**
	 * Make the character move inside of a dungeon, in a specific direction (0 = north, 1 = east, 2 = south, 3 = west)
	 * @param place The dungeon, it need to be specified in order to generate new room
	 * @param direction The direction of the character while he is moving
	 */
	public void move(Dungeon place, int direction){
		switch(direction) {
		case 0 :
			this.Position[1]--;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 1 :
			this.Position[0]++;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 2 :
			this.Position[1]++;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 3 :
			this.Position[0]--;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		default :
			return;
		}
	}
	
	/**
	 * display the 2 position values in the terminal
	 */
	public void getPosition() {
		System.out.println("x :"+Position[0]);
		System.out.println("y :"+Position[1]);
	}
	
	public int getPositionX() {
		return Position[0];
	}
	
	public int getPositionY() {
		return Position[1];
	}
	
}
