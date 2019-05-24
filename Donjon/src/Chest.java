import java.io.IOException;

public class Chest {

	boolean open;
	Equipment content;
	
	Chest() throws IOException{
		
		System.out.println("Chest generated");
		
		open = false;
		System.out.println("open = false");
		content = Generation.generateStuff();
		
	}
	
	public Equipment getContent(){
		System.out.println("getting content");
		
		this.open = true;
		System.out.println("Open ="+open);
		
		return content;
		
	}
	
	public void openChest(MainCharacter hero) throws IOException {
		System.out.println("[OPENING THE CHEST]");
		
		System.out.println("open="+open);
		
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
