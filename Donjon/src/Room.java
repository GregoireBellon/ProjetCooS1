import java.io.IOException;

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
	 * When the room is created, it get one door where the player come from, the three other are randomly generated
	 * @param a is the x position of the new room
	 * @param b is the y position of the new room
	 * @param direction depends on the point where the player is coming from, it go from 0 to 3 (order similar to door)
	 * @throws IOException 
	 */
	public Room (int a,int b,int direction,Dungeon d) throws IOException{ 
		int i;
		x = a;
		y = b;
		for (i=0;i<4;i++) {
			if (i != direction) {
				double r=Math.random()*100;
				switch (i) {
				case 0:
					if (r<=75 && d.GetRoom(a, b-1) == null) {
						Door[i]=true;
					}
					else if (d.GetRoom(a, b-1) != null && d.GetRoom(a, b-1).getDoor(2) == true) {
						Door[i]=true;
					}
					else {
						Door[i]=false;
					}
				break;
				case 1:
					if (r<=75 && d.GetRoom(a+1, b) == null) {
						Door[i]=true;
					}
					else if (d.GetRoom(a+1, b) != null && d.GetRoom(a+1, b).getDoor(3) == true) {
						Door[i]=true;
					}
					else {
						Door[i]=false;
					}
				break;
				case 2:
					if (r<=75 && d.GetRoom(a, b+1) == null) {
						Door[i]=true;
					}
					else if (d.GetRoom(a, b+1) != null && d.GetRoom(a, b+1).getDoor(0) == true) {
						Door[i]=true;
					}
					else {
						Door[i]=false;
					}
				break;
				case 3:
					if (r<=75 && d.GetRoom(a-1, b) == null) {
						Door[i]=true;
					}
					else if (d.GetRoom(a-1, b) != null && d.GetRoom(a-1, b).getDoor(1) == true) {
						Door[i]=true;
					}
					else {
						Door[i]=false;
					}
				break;
				}
			}
		}
		
							

				
	///////////////////////////// Content of the room
		is_there_ennemy=generateBoolean(70);
		is_there_chest=generateBoolean(40);
		if(is_there_ennemy) {
			ennemy=Generation.generateCharacter(this);
			System.out.println("there is ennemy");
		}
		if(is_there_chest) {
			System.out.println("there is chest");
			chest = new Chest();
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
	
	public Chest getChest() {
		return chest;
	}

	
	/**
	 * generate a boolean
	 * @param chances chances that the boolean is true, between 1 and 100
	 * @return
	 */
	public static boolean generateBoolean(int chances) {

		double alea = Math.random()*100;
		
		if(alea<=chances) {
			return true;
		}
		return false;
		
	}

	public boolean getIs_there_chest() {
		return is_there_chest;
	}
	
	public boolean getIs_there_ennemy() {
		return is_there_ennemy;
	}
	
	public void setIs_there_ennemy(boolean is_there_ennemy) {
		this.is_there_ennemy = is_there_ennemy;
	}
	
	public void setIs_there_chest(boolean is_there_chest) {
		this.is_there_chest = is_there_chest;
	}
	public Character getEnnemy() {
		return ennemy;
	}
}
