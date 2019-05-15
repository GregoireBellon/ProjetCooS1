import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		boolean fin = false;
		
		Dungeon D = new Dungeon (50,50);
		
		Weapon Dagger = new Weapon ("Dagger",4);
		
		int position[]= {50,50};
		
		MainCharacter Karen = new MainCharacter("Karen",position,Dagger);
		
		while (fin == false) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Press a number to chose what to do :");
			if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(0) == true) {
				System.out.println("8 - go to the north");
			}
			if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(1) == true) {
				System.out.println("6 - go to the east");
			}
			if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(2) == true) {
				System.out.println("2 - go to the south");
			}
			if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(3) == true) {
				System.out.println("4 - go to the west");
			}
			int i = scan.nextInt();
			if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(0) == true && i == 8) {
				Karen.move(D, 0);
			}
			else if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(1) == true && i == 6) {
				Karen.move(D, 1);
			}
			else if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(2) == true && i == 2) {
				Karen.move(D, 2);
			}
			else if (D.GetRoom(Karen.getPositionX(), Karen.getPositionY()).getDoor(3) == true && i == 4) {
				Karen.move(D, 3);
			}
			else {
				System.out.println("Invalid command");
			}
		}
	
	
	
}
}

