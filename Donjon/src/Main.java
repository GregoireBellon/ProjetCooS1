import java.io.File;
import java.io.IOException;
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
	
	public static int[] first_position = {50,50};
	
	public static Weapon first_weapon = new Weapon("stick", 5, 60);
	
	public static MainCharacter hero = new MainCharacter("Karen",first_position, first_weapon , place, place.GetRoom(50, 50));
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		try {
			place.GenerateRoom(hero.Position[0],hero.Position[1],5);
		} catch (IOException e) {
			
	System.out.println("FATAL ERROR");
	}
		
		play();
	
	
}
	
	public static void set_avancement(int progression) {
		Main.progression=progression;
	}
	
	public static void play() throws IOException {
		System.out.println("You're an brave adventurer,\n"
				+ "You're here to break the secret of a old temple \n"
				+ "Your gps, which was indicating -13.520159, -71.975239, brutaly stop. \n"
				+ "You pass out and wake up in a strange ancient room. \n"
				+ "You wich you could go back. \n \n \n");
		
		while(true) {
		choices();
		}
		
		
	}
	
	public static void choices() throws IOException{
		
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
			hero.fightContext(current_room.getEnnemy());
		}

		//ajouter "drink potion"
		ChoiceTab tab = new ChoiceTab(choices);
		tab.makeChoice();
		
		
	}
	
}

