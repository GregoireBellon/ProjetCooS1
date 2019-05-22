import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static File bestiary_txt = new File(System.getProperty("user.dir")+"/bestiary.txt");
	public static File weapons_txt = new File(System.getProperty("user.dir") +"/weapons.txt");
	public static File bags_txt = new File(System.getProperty("user.dir") +"/bags.txt");
	public static File potions_txt = new File(System.getProperty("user.dir") +"/potions.txt");
	
	
	public static double progression=10;
	
	public static Dungeon place = new Dungeon(50, 50);
	
	public static int[] first_position = {10,10};

	public static Weapon first_weapon = new Weapon("stick", 5, 60);
	public static MainCharacter hero = new MainCharacter("Karen",first_position, first_weapon , place);
	
	public static void main(String[] args) {

		
		play();
	
	
}
	
	public static void set_avancement(int progression) {
		Main.progression=progression;
	}
	
	public static void play() {
		System.out.println("You're an brave adventurer,\n"
				+ "You're here to break the secret of a old temple \n"
				+ "Your gps, which was indicating -13.520159, -71.975239, brutaly stop. \n"
				+ "You pass out and wake up in a strange ancient room. \n"
				+ "You wich you could go back.");
		
		
	}
	
	public static void choices(){
		
		List<Choice> choices = new ArrayList<Choice>();
		Room current_room = place.GetRoom(hero.getPositionX(), hero.getPositionY());
		
		if(current_room.)
		
		
	}
	
}

