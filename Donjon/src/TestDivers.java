import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDivers {

	public static void main(String[] args) throws IOException {

		
		int[] position = {5,5};
		Dungeon d = new Dungeon(20, 20);
		Weapon w = new Weapon("Lunettes", 1, 50);
		Weapon w1 = new Weapon("Ptite Massue", 1, 50);
		MainCharacter Louis = new MainCharacter("Louis", position, w, d);
		Character skeletton = new Character("Skeletton", 10, w1, d);
		
		System.out.println(Louis.toString());
		
		Generation.generatePotion();
	
	//Louis.fightContext(skeletton);
		Generation.generateWeapon(false);
		
		Generation.generateBag();
		
		Generation.generateCharacter();
		
		
	}

}
