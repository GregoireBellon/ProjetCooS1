import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Permit to select a choice, and execute it
 * @author Gregoire
 *
 */
public class ChoiceTab {

	/**
	 * list of all the choices
	 */
	List<Choice> choices;

	/**
	 * Initialize the object
	 * @param choices List of choices that the player have (can be expanded by addChoice())
	 */
	ChoiceTab(List<Choice> choices) {

		this.choices = choices;

	}

	/**
	 * 
	 * @param choice single choice that the player have (can be expanded by addChoice())
	 */
	ChoiceTab(Choice choice) {
		this.choices = new ArrayList<Choice>();
		this.choices.add(choice);
	}

	
	/**
	 * allow the programmer to add a choice
	 * @param add choice that the programmer want to add
	 */
	public void add(Choice add) { // add a choice to the tab
		choices.add(add);
		return;
	}
	

	/**
	 * Main function, propose all the choices to the player and let him choose. Then, execute the choice.
	 * @return Is the choice "active"? (that make a fight go on) Exemple : attacking is active, checking inventory is not.
	 * @throws IOException due to the character generation
	 */
	public boolean makeChoice() throws IOException { // main function. Used to show the choices and select one. Boolean
														// return if the choice is active (attacking is active, checking
														// inventory is not)
		boolean choice_correct = false; // id the player don't choose a choice that is featured
		Choice choice_selected = null; // choice that the player select
		int choice_index; // index of the choice

		while (!choice_correct) {
			try {
				this.question();
				choice_index = ScannerEntry.getInt() - 1;// ScannerEntry.getInt() - 1;
				choice_selected = choices.get(choice_index);
				choice_correct = true;

			} catch (java.lang.IndexOutOfBoundsException e) {
				System.out.println("This choice doesn't exist!");
			}
		}

		Main.skipLines();
		
		switch (choice_selected.action) {

		case "moveN": // move north
			choice_selected.from.move(choice_selected.place, 0);
			System.out.println("moving north");
			
			return true;

		case "moveS":// move south
			choice_selected.from.move(choice_selected.place, 2);
			System.out.println("moving south");
			return true;
		case "moveE":// move east
			choice_selected.from.move(choice_selected.place, 1);
			System.out.println("moving east");
			return true;
		case "moveW":// move west
			choice_selected.from.move(choice_selected.place, 3);
			System.out.println("moving west");
			return true;

		case "attack":// attack "target" from "from"
			Weapon weapon_of_character = choice_selected.from.getUsingWeapon();
			choice_selected.target.fight(choice_selected.from, weapon_of_character.pa);
			return true;

		case "dodge":// dodge from "target"
			Main.skipLines();
			choice_selected.from.dodge(choice_selected.target);
			// System.out.println("dodging");
			return true;
		case "takeH":// take it from "from"
			Main.skipLines();
			System.out.println("You took the hit (-" + choice_selected.target.getUsingWeapon().getPa() + ")");
			System.out.println();
			choice_selected.from.loseHp(choice_selected.target.getUsingWeapon().pa); // we take the damages of the main																	// weapon
			return true;
		case "checkI":// check inventory
			choice_selected.from.checkInventory();
			return false;

		case "openC":
			choice_selected.chest.openChest(choice_selected.from);
			return true;
		case "leaveC": // leave the chest
			choice_selected.chest.open = false;
			return true;
		case "equipC": // equip with the chest content
			choice_selected.chest.getContent().equip(choice_selected.from);;
			return true;
		case"useO": //use object
			choice_selected.equip.use(choice_selected.from);
			return false;
		case"useTab": //the UI to use objects
			choice_selected.from.useTab();
			return false;
		case"exit": //quit a menu
			return true;
		case"leaveO":
			choice_selected.from.equipment_list.remove(choice_selected.equip);
			return true;
		default:
			System.out.println("choice problem!!");
			return false;
		}

	}

	
	/**
	 * display all the choices
	 */
	public String toString() {
		String out = "";

		int i;
		for (i = 0; i < choices.size(); i++) {
			out = out + (i + 1) + " ) : " + choices.get(i).getQuestion() + "\n";
		}
		return out;
	}

	/**
	 * ask the question "What do you want to do?"
	 */
	public void question() {
		System.out.println("What do you want to do ?");
		System.out.println(toString());
	}

	/**
	 * Debugging purpose, give a more detailed toString (with index of choices and attributes)
	 * @return
	 */
	public String debugtoString() { // debugging purpose
		String out = "";
		int i;
		for (i = 0; i < choices.size(); i++) {
			out = out + (i + 1) + " ) : " + choices.get(i).toString() + "\n"; // show all the choices's attributes
		}
		return out;
	}

	/**
	 * remove all the choices
	 */
	public void clear() { 
		choices.clear();
	}

}
