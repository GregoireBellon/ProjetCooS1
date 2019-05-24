import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Group of static functions that generate all the entities (stuff and characters)
 * @author Grégoire
 *
 */
public class Generation {

	/**
	 * Generate a character.
	 * The Hp depends of the Main.progression
	 * @param place
	 * @return Character generated
	 * @throws IOException due to the file reading
	 */
	public static Character generateCharacter(Room place) throws IOException {

		
		FileReader read_file = new FileReader(Main.bestiary_txt);
		BufferedReader read_buff = new BufferedReader(read_file);
		String name = "";
		String line;
		double rand;
		boolean loop_over = false;

		while (!loop_over) {
			read_buff.mark(1000);
			while (read_buff.ready()) {
				line = read_buff.readLine();
				rand = Math.random();
				if (rand < (0.034482759)) { // this is 1/29 because they are 29 possible characters
					name = line;
					// System.out.println(line);
					loop_over = true;
					break;
				}
			}

			read_buff.reset();

		}

		read_buff.close();
		read_file.close();

		double hp = 20 + Main.progression * 0.60;

		Character out = new Character(name, (int) hp, generateWeapon(true), Main.place);


		return out;

	}

	/**
	 * Generate a weapon.
	 * The damages depends of the Main.progression
	 * @param place
	 * @return Character generated
	 * @throws IOException due to the file reading
	 */
	public static Weapon generateWeapon(boolean ennemy) throws IOException {
		double progression;
		if (ennemy) {
			progression = (Main.progression * 0.60);}
		else {
			progression = Main.progression;
		}
		
		FileReader read_file = new FileReader(Main.weapons_txt);
		BufferedReader read_buff = new BufferedReader(read_file);
		String name = "";
		String line;
		double rand;
		boolean loop_over = false; // is the loop over

		while (!loop_over) { //while it's not
			read_buff.mark(1000);
			while (read_buff.ready()) {
				line = read_buff.readLine();
				rand = Math.random();
				if (rand < (0.05263157894)) { // this is 1/19 because they are 19 weapons
					name = line;
					// System.out.println(line); //when we find the result the loop is over
					loop_over = true;
					break;
				}
			}

			read_buff.reset();

		}

		read_buff.close();
		read_file.close();

		// System.out.println("terminé");
		double precision = 60 + (Math.random() * 20) - 10;
		double pa = progression + (2 * (progression / (Math.random() * 3 + 1))); // progression + (divide progression
																					// between 1 and 4 and multiply the
																					// total by 2)
		Weapon out = new Weapon(name, (int) pa, (int) precision);

		return out;

	}

	/**
	 * Generate random equipment.
	 * @throws IOException due to the file reading
	 */
	public static Equipment generateStuff() throws IOException{
		
		double rand = Math.random();
		
				if(rand<0.3) {
					
			Potion pout = generatePotion();
			return pout;
			
			
		}
		else if(rand<0.5) {

			Bag bout = generateBag();
			return bout;

		}
		else if(rand>0.5) {

			Weapon wout = generateWeapon(false);
			return wout;
		}
		return null;
		
		
		
	}

	
	/**
	 * Generate a bag.
	 * The size depends of the size of the player's bag. It has a random dimension too.
	 * @param place
	 * @return Character generated
	 * @throws IOException due to the file reading
	 */
	public static Bag generateBag() throws IOException{		
		
		FileReader read_file = new FileReader(Main.bags_txt);
		BufferedReader read_buff = new BufferedReader(read_file);
		String name = "";
		String line;
		double rand;
		boolean loop_over = false;

		while (!loop_over) {
			read_buff.mark(1000);
			while (read_buff.ready()) {
				line = read_buff.readLine();
				rand = Math.random();
				if (rand < (0.04761904761)) { // this is 1/19 because they are 19 weapons
					name = line;
					// System.out.println(line);
					loop_over = true;
					break;
				}
			}

			read_buff.reset();

		}

		
		read_buff.close();
		read_file.close();

		
		int size = (int) Math.abs((Main.hero.actual_bag.size+(Math.random()*4)-2));
		
		Bag out = new Bag(name, size);
		

		return out;
	}
	
	/**
	 * Generate a potion.
	 * The power of healing depends of the Main.progression
	 * @param place
	 * @return Character generated
	 * @throws IOException due to the file reading
	 */
	public static Potion generatePotion() {		
		
		try {
		FileReader read_file = new FileReader(Main.potions_txt);
		BufferedReader read_buff = new BufferedReader(read_file);
		String name = "";
		String line;
		boolean loop_over = false;
		
		
		
		while (!loop_over) {
			read_buff.mark(10000);
			
			while (read_buff.ready()) {
				line = read_buff.readLine();
				double rand = Math.random();
				if (rand < (0.066666666666667)) { // this is 1/18 because they are 15 potions
					name = line;
					// System.out.println(line);
					loop_over = true;
					break;
				}
				
			}

			read_buff.reset();

		}

		read_buff.close();
		read_file.close();

		int give_hp = (int) Math.abs(((Main.hero.hp_max)+(Main.progression/2)));
		
		Potion out = new Potion(name, give_hp);
		
		return out;
		}
		catch(IOException e) {
			System.out.println("Error in potion creation");
		}
		catch(ExceptionInInitializerError e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
