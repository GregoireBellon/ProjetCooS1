import java.io.IOException;
/**
 * 
 * @author Hugo
 * 
 * Contain all the rooms and allow to generate some
 *
 */
public class Dungeon {
	
	Room map[][] = new Room[40][40];
	
	/**
	 * When the dungeon get instanced, a first room is created at the x,y position
	 * @param x first position value of the first room
	 * @param y second position value of the first room
	 * @throws IOException 
	 */
	Dungeon(int x,int y)  {

	
	}
	
	/**
	 * Check if there is already a room at the x,y position, if not, it generate one
	 * @param x first position value
	 * @param y second position value
	 * @param direction from which direction the player is coming from
	 * @throws IOException 
	 */
	public void GenerateRoom(int x,int y,int direction) throws IOException {
		if (map[x][y] == null) {
			map[x][y] = new Room(x,y,direction,this);
		}
	}
	/**
	 * 
	 * @param x X coordinate of the room that we want to get
	 * @param y Y coordinate of the room that we want to get
	 * @return Room
	 */
	public Room GetRoom(int x,int y) {
		return map[x][y];
	}

	/**
	 * return the map, by a 2 dimensions array
	 * @return Map
	 */
	public Room[][] getMap() {
		return map;
	}
	

	
}
