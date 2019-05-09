
public class Dungeon {
	
	Room map[][] = new Room[100][100];
	
	Dungeon(int x,int y) {
		GenerateRoom(x,y,5);
	}
	
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
