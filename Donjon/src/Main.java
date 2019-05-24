import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	/**
	 * txt file that contain all the possible character's names
	 */
	public static File bestiary_txt = new File(System.getProperty("user.dir")+"/bestiary.txt");
	/**
	 * txt file that contain all the possible weapon's names
	 */
	public static File weapons_txt = new File(System.getProperty("user.dir") +"/weapons.txt");
	/**
	 * txt file that contain all the possible bag's names
	 */
	public static File bags_txt = new File(System.getProperty("user.dir") +"/bags.txt");
	/**
	 * txt file that contain all the possible potion's names
	 */
	public static File potions_txt = new File(System.getProperty("user.dir") +"/potions.txt");
	

	/**
	 * determine the characteristics of the generated entities
	 */
	public static double progression=10;
	
	/**
	 * map where the player play
	 */
	public static Dungeon place = new Dungeon(20, 20);
	
	/**
	 * first position of the player
	 */
	public static int[] first_position = {20,20};
	
	/**
	 * first weapon of the player
	 */
	public static Weapon first_weapon = new Weapon("stick", 10, 60);
	
	/**
	 * Character that the player controls
	 */
	public static MainCharacter hero = new MainCharacter("Karen",first_position, first_weapon , place, place.GetRoom(20, 20));
	
	
	
	
	
	/**
	 * Generate the first room and launch the game
	 * @param args
	 * @throws IOException due to the character generation
	 */
	public static void main(String[] args) throws IOException {
		
		try {
			place.GenerateRoom(hero.Position[0],hero.Position[1],5);
		} catch (IOException e) {
			
	System.out.println("FATAL ERROR");
	}
		
		play();
		
		System.out.println("");
	
	
}
	
	public static void set_avancement(double d) {
		Main.progression=d;
	}
	
	/**
	 * It's the core of the game, it detect when the player die.
	 * @throws IOException Due to the generation of the characters (reading into txt file)
	 */
	public static void play() throws IOException {
		System.out.println("You're an brave adventurer,\n"
				+ "You're here to break the secret of a old temple \n"
				+ "Your gps, which was indicating -13.520159, -71.975239, brutaly stop. \n"
				+ "You pass out and wake up in a strange ancient room. \n"
				+ "You wish you could go back. \n \n \n");
		
		boolean end = false;
		while(!end) {
		end=choices();
		}
		if(hero.alive=true) {
			System.out.println("You can see a ladder.... \n"
					+ "There it is! The sunlight! \n"
					+ "You survived to this temple, but it may be time to retire.");
		return;
		}
		else {
			System.out.println("Another adventurer died from the temple. \n"
					+ "When will this malediction end? \n"
					+ "Not today for sure.");
		}
		
		
		
	}
	
	
	/**
	 * Allow the player to do all the choices when he's not in a fight
	 * @return Is the game ended (player dead - progression > 100)
	 * @throws IOException
	 */
	public static boolean choices() throws IOException{
		
		
		List<Choice> choices = new ArrayList<Choice>();
		Room current_room = place.GetRoom(hero.getPositionX(), hero.getPositionY());
		
		if(current_room.getDoor(0)) {
			Choice north = new Choice("Go to the north", "moveN", hero, hero, place);
			choices.add(north);
		}
		if(current_room.getDoor(1)) {
			Choice east = new Choice("Go to the east", "moveE", hero, hero, place);
			choices.add(east);
		}
		if(current_room.getDoor(2)) {
			Choice south = new Choice("Go to the south", "moveS", hero, hero, place);
			choices.add(south);
		}
		if(current_room.getDoor(3)) {
			Choice west = new Choice("Go to the west", "moveW", hero, hero, place);
			choices.add(west);
		}
		
		Choice checkI= new Choice("Check inventory", "checkI", hero, hero, place);
		choices.add(checkI);
		
		if(current_room.getIs_there_chest() && !current_room.getChest().open) {
			Choice chest = new Choice("Open chest", "openC", hero, hero, place, current_room.getChest());
			choices.add(chest);
		}
		
		if(current_room.getIs_there_ennemy()) {
			System.out.println("There is an evil presence in this room.... \n \n");
			hero.fightContext(current_room.getEnnemy());
		}
		Choice use_something = new Choice("Use an object", "useTab", hero, hero, place);
		choices.add(use_something);
		
		hero.life(); //show lifebar

		
		ChoiceTab tab = new ChoiceTab(choices);
		tab.makeChoice();
		
		System.out.println("\n \n");
		
		if(!hero.alive || progression > 100) {
			return true;
		}
		
		return false;
		
	}
	
	
	/**
	 * used to skip 40 lines
	 */
	public static void skipLines() {
		for(int i =0; i<40; i++) {System.out.println();}
	}
	
}

