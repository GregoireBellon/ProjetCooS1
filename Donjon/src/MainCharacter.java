
public class MainCharacter extends Character{
	
	protected Bag actual_bag;
	
	/**
	 * Position[0] = x,  Position[1] = y
	 */
	protected int Position[] = new int[2];
	
	
	public MainCharacter(String name, int[] Position) {
		super(name, 100);
		
		this.Position[0]=Position[0];
		this.Position[1]=Position[1];
		
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
