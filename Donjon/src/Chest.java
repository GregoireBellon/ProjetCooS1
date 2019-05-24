import java.io.IOException;
/**
 * Entity placed in a room that contain equipment
 * 
 * @author Hugo Valadon
 * @author Grégoire Bellon
 * 
 */
public class Chest {
/**
 * Has the chest been opened? (true = yes)
 */
	boolean open;
	/**
	 * Define the content of the chest
	 */
	Equipment content;
	
	/**
	 * Initialize a chest with equipment in it
	 * @throws IOException due to the generation of entity
	 */
	Chest() throws IOException{
		
		
		open = false;
		content = Generation.generateStuff();
		
	}

	
	/**
	 * @return equipment that is in the chest
	 */
	public Equipment getContent(){
		
		this.open = true;
		
		return content;
		
	}
	
	/**
	 * Display the content of the chest and ask to the hero if he wants to take it
	 * @param hero
	 * @throws IOException
	 */
	public void openChest(MainCharacter hero) throws IOException {
		System.out.println("[OPENING THE CHEST]");
		
		
		if(open == true) {
			System.out.println("Chest already opened");
			return;
		}
		
		System.out.println("There is "+content+"\n"
				+ "in this chest...");
		Choice take = new Choice("Equip "+content.getName(),"equipC", hero, hero, Main.place, this);
		Choice leave = new Choice("Leave it","leaveC", hero, hero, Main.place, this);//coder equip et leave
		ChoiceTab choices =  new ChoiceTab(take);
		choices.add(leave);
		choices.makeChoice();
	}
	
}
