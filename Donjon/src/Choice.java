
public class Choice {

	public String question;
	public String action;
	public Character target;
	public MainCharacter from;
	public Dungeon place;
	public Chest chest;
	public Equipment equip;

	public Choice(String question, String action, Character target, MainCharacter from, Dungeon place) {
		this.question = question;
		this.action = action;
		this.target = target;
		this.from = from;
		this.place = place;
		this.chest = null;
		this.equip=null;
	}
	 
	public Choice(String question, String action, Character target, MainCharacter from, Dungeon place, Chest chest){
	this(question, action, target, from, place);
	this.chest=chest;
	
	}
	 
	public Choice(String question, String action, Character target, MainCharacter from, Dungeon place, Equipment equip) {
			this(question, action, target, from, place);
			this.equip=equip;

	 }


	@Override
	public String toString() {

		String line = question + "\n" + "(target = " + target.getName() + "\n action = " + action + "\n" + "from : "
				+ from.getName();

		return line;

	}

	public String getQuestion() {
		return question;
	}

}
