import java.util.ArrayList;
import java.util.List;

public class ChoiceTab {

	List<Choice> choices;

	ChoiceTab(List<Choice> choices) {

		this.choices = choices;

	}
	
	ChoiceTab(Choice choice){
		this.choices = new ArrayList<Choice>();
		this.choices.add(choice);
	}

	public void add(Choice add) { //add a choice to the tab
		choices.add(add);
		return;
	}

	public boolean makeChoice() { //main function. Used to show the choices and select one. Boolean return if the choice is active (attacking is active, checking inventory is not)
		boolean choice_correct = false; //id the player don't choose a choice that is featured
		Choice choice_selected = null; //choice that the player select
		int choice_index; //index of the choice

		while (!choice_correct) {
			try {
				this.question();
				choice_index = ScannerEntry.getInt() - 1;
				choice_selected = choices.get(choice_index);
				choice_correct = true;

			} catch (java.lang.IndexOutOfBoundsException e) {
				System.out.println("This choice doesn't exist!");
			}
		}

		switch (choice_selected.action) {

		case "moveN": //move north
			choice_selected.from.move(choice_selected.place, 0);
			System.out.println("moving north");
			return true;
			
		case "moveS"://move south
			choice_selected.from.move(choice_selected.place, 2);
			System.out.println("moving south");
			return true;
		case "moveE"://move east
			choice_selected.from.move(choice_selected.place, 1);
			System.out.println("moving east");
			return true;
		case "moveW"://move west
			choice_selected.from.move(choice_selected.place, 3);
			System.out.println("moving west");
			return true;

		case "attack"://attack "target" from "from"
			Weapon weapon_of_character = choice_selected.from.getUsingWeapon();
			choice_selected.target.fight(choice_selected.from, weapon_of_character.pa);
			return true;

		case "dodge"://dodge from "target"
			choice_selected.from.dodge(choice_selected.target);
			System.out.println();
			//System.out.println("dodging");
			return true;
		case "takeH"://take it from "from"
			System.out.println("You took the hit (-"+choice_selected.target.getUsingWeapon().getPa()+")");
			System.out.println();
			choice_selected.from.loseHp(choice_selected.target.getUsingWeapon().pa); //we take the damages of the main weapon
			return true;
			
		case "checkI"://check inventory
			choice_selected.from.checkInventory();
			return false;
		default:
			System.out.println("choice problem!!");
			return false;
		}

	}

	public String toString() {
		String out = "";

		int i;
		for (i = 0; i < choices.size(); i++) {
			out = out + (i + 1) + " ) : " + choices.get(i).getQuestion() + "\n";
		}
		return out;
	}

	public void question() {
		System.out.println("What do you want to do ?");
		System.out.println(toString());
	}

	public String debugtoString() { // debugging purpose
		String out = "";
		int i;
		for (i = 0; i < choices.size(); i++) {
			out = out + (i + 1) + " ) : " + choices.get(i).toString() + "\n"; //show all the choices's attributes
		}
		return out;
	}
	public void clear() {
		choices.clear();
	}

}
