
public class Room {
	
	private int x;
	private int y;
	private boolean is_there_ennemy; //is there an ennemy in the room?
	private boolean is_there_chest; //is there a chest in the room?

	private Character ennemy;
	private Chest chest;
	
	/**
	 * Every boolean stands for a door (in order: North,East,South,West), True if there is a door, false if not
	 */
	private boolean Door[] = new boolean[4];
	
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param direction depends on the point where the player is coming from, it go from 0 to 3 (order similar to door)
	 */
	Room(int a,int b,int direction){ 
		int i;
		x = a;
		y = b;
		for (i=0;i<4;i++) {
			if (i != direction) {
				double r=Math.random()*100;
				if (r<=50) {
					Door[i]=true;
				}
				else {
					Door[i]=false;
				}
			}
		}
		switch (direction) {
		case 0:
			Door[2] = true;
		break;
		case 1:
			Door[3] = true;
		break;
		case 2:
			Door[0] = true;
		break;
		case 3:
			Door[1] = true;
		break;
		default:
		}
				
	///////////////////////////// Content of the room
		is_there_ennemy=generateBoolean(15);
		if(is_there_ennemy) {
			Ennemy=Generation.generate_ennemy();//à coder_
		}
		
		
		
	
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public boolean getDoor(int i) {
		return Door[i];
	}
	
	/**
	 * renerate a boolean
	 * @param chances chances that the boolean is true, between 1 and 100
	 * @return
	 */
	private boolean generateBoolean(int chances) {

		double alea = Math.random();
		
		if(alea>=chances) {
			return true;
		}
		return false;
		
	}
	
}
