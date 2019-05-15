
public class TestDivers {

	public static void main(String[] args) {

		int[] position = {5,5};
		
		Weapon w = new Weapon("Lunettes", 1);
		MainCharacter Louis = new MainCharacter("Louis", position, w);

		Equipment a = new Equipment("Ce");
		a.equip(Louis);
		Equipment z = new Equipment("Programme");
		z.equip(Louis);
		Equipment e = new Equipment("Est");
		e.equip(Louis);
		Equipment r = new Equipment("tout");
		r.equip(Louis);
		Equipment t = new Equipment("simplement");
		t.equip(Louis);
		Equipment y = new Equipment("inoui");
		y.equip(Louis);
		Equipment u = new Equipment("!");
		u.equip(Louis);
		Equipment i = new Equipment(":)");
		i.equip(Louis);




		
		System.out.println(Louis);
		
	}

}
