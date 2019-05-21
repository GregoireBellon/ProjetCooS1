import java.io.File;
import java.util.Scanner;

public class Main {
	
	public static File bestiary_txt = new File(System.getProperty("user.dir")+"/bestiary.txt");
	public static File weapons_txt = new File(System.getProperty("user.dir") +"/weapons.txt");
	
	public static double progression=10;
	
	public static Dungeon place = new Dungeon(20, 20);
	
	public static int[] first_position = {10,10};

	public static Weapon first_weapon = new Weapon("stick", 5, 60);
	public static MainCharacter hero = new MainCharacter("Karen",first_position, first_weapon , place);
	
	public static void main(String[] args) {
	
		boolean fin = false;
		
		Dungeon D = new Dungeon (50,50);
		
		Weapon Dagger = new Weapon ("Dagger",4, 20);
		
		int position[]= {50,50};
		
		MainCharacter Karen = new MainCharacter("Karen",position,Dagger, D);
		
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
	
	public void set_avancement(int progression) {
		this.progression=progression;
	}
	
}

