import java.util.Scanner; 


public class Main {

	public static void main(String[] args) {
		
		int depart[] = new int[2];
		depart[0] = 50;
		depart[1] = 50;
		Weapon Dagger = new Weapon("dagger",6);
		
		
		MainCharacter Karen = new MainCharacter("Karen", depart,Dagger);
		Dungeon D = new Dungeon(50,50);
		
		while (true){
			boolean north,east,south,west;
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Type a number to chose what to do :");
			if (D.GetRoom(Karen.getPositionX(),Karen.getPositionY()).getDoor(0) == true) {
				System.out.println("8 - Move to the North");
				north = true;
			}
			else {
				north = false;
			}
			if (D.GetRoom(Karen.getPositionX(),Karen.getPositionY()).getDoor(1) == true) {
				System.out.println("6 - Move to the East");
				east = true;
			}
			else {
				east = false;
			}
			if (D.GetRoom(Karen.getPositionX(),Karen.getPositionY()).getDoor(2) == true) {
				System.out.println("2 - Move to the South");
				south = true;
			}
			else {
				south = false;
			}
			if (D.GetRoom(Karen.getPositionX(),Karen.getPositionY()).getDoor(3) == true) {
				System.out.println("4 - Move to the West");
				west = true;
			}
			else {
				west = false;
			}
			
			int i = scan.nextInt();
			if (i == 8 && north == true) {
				Karen.move(D, 0);
			}
			else if (i == 6 && east == true) {
				Karen.move(D, 1);
			}
			else if (i == 2 && south == true) {
				Karen.move(D, 2);
			}
			else if (i == 4 && west == true) {
				Karen.move(D, 3);
			}
			else {
				System.out.println("The typed number isn't linked with any action");
			}
			
		}
		
		
	}

}
