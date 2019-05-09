
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
	
	public void move(Dungeon place, int direction){
		switch(direction) {
		case 0 :
			this.Position[1]--;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 1 :
			this.Position[0]++;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 2 :
			this.Position[1]++;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		case 3 :
			this.Position[0]--;
			place.GenerateRoom(this.Position[0], this.Position[1], direction);
			break;
		default :
			return;
		}
	}
	
	public void getPosition() {
		System.out.println("x :"+Position[0]);
		System.out.println("y :"+Position[1]);

	}
	
}
