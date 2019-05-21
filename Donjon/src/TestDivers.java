
public class TestDivers {

	public static void main(String[] args) {

		int[] position = {5,5};
		
		Weapon w = new Weapon("Lunettes", 20);
		Weapon w1 = new Weapon("Ptite Massue", 1);
		MainCharacter Louis = new MainCharacter("Louis", position, w);
		Character skeletton = new Character("Skeletton", 10, w1);
		skeletton.fight(0, Louis);
		
		
		
		System.out.println(Louis);
		
	}

}
