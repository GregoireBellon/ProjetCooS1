
public class Choice {
	
	public String question;
	public String action;
	public Character target;
	public MainCharacter from;
	public Dungeon place;
	
	
	Choice(String question, String action, Character target, MainCharacter from, Dungeon place){
		this.question = question;
		this.action=action;
		this.target=target;
		this.from=from;
		this.place=place;
	}
	
	@Override
	public String toString() {

		String line= question+"\n"
				+ "(target = "+target.getName()
				+ "\n action = "+action+"\n"
				+ "from : "+from.getName();
		
		return line;
		
		
	}
	
	public String getQuestion() {
		return question;
	}
	
	
}
