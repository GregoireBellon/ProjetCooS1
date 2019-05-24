/**
 * A choice his the projection of an action
 * It can be executed in ChoiceTab
 * @author Grégoire
 *
 */
public class Choice {

	/**
	 * Define the question exemple "Use this weapon"
	 */
	public String question;
	/**
	 * Define the action. Can be : 
	 * moveN : move to the north
	 * moveS : move to the south
	 * moveE : move to the east
	 * moveW : move to the west
	 * attack : attack an ennemy
	 * dodge : try to dodge
	 * takeH : take the hit
	 * checkI : open the inventory
	 * openC : open a chest
	 * leaveC : leave the equipment of a chest
	 * equipC : equip the equipment of a chest
	 * useO : use an equipment
	 * useTab : go to useTab()
	 * exit : exit of a menu
	 * leaveO : leave an equipment on the ground
	 */
	public String action;
	/**
	 * target of the action
	 */
	public Character target;
	/**
	 * define who did the action
	 */
	public MainCharacter from;
	/**
	 * define where the choice take place
	 */
	public Dungeon place;
	/**
	 * define a possible chest that is involved in the choice
	 */
	public Chest chest;
	
	/**
	 * define a possible equipment that is involved in the choice
	 */
	public Equipment equip;

	/**
	 * Initialize the choice without chest
	 * @param question
	 * @param action
	 * @param target
	 * @param from
	 * @param place
	 */
	public Choice(String question, String action, Character target, MainCharacter from, Dungeon place) {
		this.question = question;
		this.action = action;
		this.target = target;
		this.from = from;
		this.place = place;
		this.chest = null;
		this.equip=null;
	}
	
	/**
	 * Initialize the choice with chest
	 * @param question
	 * @param action
	 * @param target
	 * @param from
	 * @param place
	 */
	public Choice(String question, String action, Character target, MainCharacter from, Dungeon place, Chest chest){
	this(question, action, target, from, place);
	this.chest=chest;
	
	}
	
	/**
	 * Initialize the choice with equipment
	 * @param question
	 * @param action
	 * @param target
	 * @param from
	 * @param place
	 */
	public Choice(String question, String action, Character target, MainCharacter from, Dungeon place, Equipment equip) {
			this(question, action, target, from, place);
			this.equip=equip;

	 }

/**
 * return all the content of a choice (all tje attributes) in a string
 */
	@Override
	public String toString() {

		String line = question + "\n" + "(target = " + target.getName() + "\n action = " + action + "\n" + "from : "
				+ from.getName();

		return line;

	}
/**
 * @return question
 */
	public String getQuestion() {
		return question;
	}

}
