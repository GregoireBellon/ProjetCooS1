
public class Dungeon {
	
	Room map[][] = new Room[100][100];
	
	/**
	 * When the dungeon get instanced, a first room is created at the x,y position
	 * @param x first position value of the first room
	 * @param y second position value of the first room
	 */
	Dungeon(int x,int y) {
	GenerateRoom(x,y,5);
	
	}
	
	/**
	 * Check if there is already a room at the x,y position, if not, it generate one
	 * @param x first position value
	 * @param y second position value
	 * @param direction from which direction the player is coming from
	 */
	public void GenerateRoom(int x,int y,int direction) {
		if (map[x][y] == null) {
			map[x][y] = new Room(x,y,direction);
		}
	}
	
	public Room GetRoom(int x,int y) {
		return map[x][y];
	}

	public Room[][] getMap() {
		return map;
	}
	
}
