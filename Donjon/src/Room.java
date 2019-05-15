
public class Room {
	
	private int x;
	private int y;
	
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
	
	
}
