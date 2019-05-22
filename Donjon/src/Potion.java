
public class Potion extends Equipment {

	private int value = 0;

	Potion(String name, int value) {
		super(name);
		this.value = value;
	}

	public void drink(Character target) {

		if (value == 0) {
			System.out.println("This potion is empty");

			return;
		}

		target.addHp(value);
		return;
		
	}
	
	@Override
	public String toString() {

		String out = super.getName()+" : +"+value+"hp";
		
		return out;
	}

}
