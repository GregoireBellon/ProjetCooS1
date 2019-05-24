import java.io.IOException;

public class Chest {

	boolean open;
	Equipment content;
	
	Chest() throws IOException{
		
		
		open = false;
		content = Generation.generateStuff();
		
	}
	
	public Equipment getContent(){
		
		this.open = true;
		
		return content;
		
	}
	
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
