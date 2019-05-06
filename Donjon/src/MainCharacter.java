
public class MainCharacter extends Character{
	
	protected Bag actual_bag;
	
	public MainCharacter(String name) {
		super(name, 100);
		
	}
	
	public boolean canAddEquipement() {
		if(equipment_list.size()<actual_bag.size) {
			return true;
		}
		return false;
	}
	
	public void moove(){
		
	}
	
}
