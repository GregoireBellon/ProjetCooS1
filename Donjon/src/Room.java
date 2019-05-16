
public class Room {
	
	private int x;
	private int y;
	private Event event;
	
	/**
	 * Every boolean stands for a door (in order: North,East,South,West), True if there is a door, false if not
	 */
	private boolean Door[] = new boolean[4];
	
	
	/**
	 * When the room is created, it get one door where the player come from, the three other are randomly generated
	 * @param a is the x position of the new room
	 * @param b is the y position of the new room
	 * @param direction depends on the point where the player is coming from, it go from 0 to 3 (order similar to door)
	 */
	Room(int a,int b,int direction){ 
		event = new Event();
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

	public Event getEvent() {
		return event;
	}
		
	
}
