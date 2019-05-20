import java.util.ArrayList;
import java.util.List;

public class TestDivers {

	public static void main(String[] args) {

		int[] position = {5,5};
		Dungeon d = new Dungeon(20, 20);
		Weapon w = new Weapon("Lunettes", 1, 100);
		Weapon w1 = new Weapon("Ptite Massue", 1, 100);
		MainCharacter Louis = new MainCharacter("Louis", position, w, d);
		Character skeletton = new Character("Skeletton", 10, w1, d);
		
		System.out.println(Louis.toString());
		
		Louis.fightContext(skeletton);
				
		
	}

}
