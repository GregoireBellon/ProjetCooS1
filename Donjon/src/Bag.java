/**
 * Define the size of the player's inventory
 * 
 * @author Hugo Valadon
 * @author Grégoire Bellon
 *
 */
public class Bag extends Equipment{
	/**
	 * number of items that a player can put in his inventory
	 */
	public int size; //size of the bag, how many object can fit in it
	
	/**
	 * A bag is instanced with a name and a max number of item
	 * @param name The name of the bag
	 * @param size The maximum number of item in the bag
	 */
	Bag(String name, int size){
		super(name);
		this.size=size;
	}
	/**
	 * return name and size in a String
	 */
	@Override
	public String toString() {
		
		String out;
		
		out = super.getName()+" : "+size+" slots";
		
		return out;
	}
	
	
	/**
	 * replace the actual bag of the player with this one, which is removed of the player inventory
	 */
	@Override
	public void use(MainCharacter target) {
		boolean choice_correct=false;
		
		if(target.equipment_list.size()>size) {
			System.out.println("This bag does't have enought space!");
			return;
		}
		
		while(!choice_correct) {
			System.out.println("Do you want to equip "+super.getName()+ "(you will loose your old backpack) \n"
					+ "yes/no");
			
			String anwser = ScannerEntry.getString();
			switch(anwser) {
			case "yes":
			target.actual_bag=this;
			choice_correct=true;
			break;
			
			}
			
		}
	}
	
}
