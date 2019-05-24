
public class Potion extends Equipment {

	private int value = 0;

	Potion(String name, int value) {
		super(name);
		this.value = value;
	}

	@Override
	public void use(MainCharacter target) {

		target.addHp(value);
		target.equipment_list.remove(this);
		
		return;
		
	}
	
	@Override
	public String toString() {

		String out = super.getName()+" : +"+value+"hp";
		
		return out;
	}
	
	

}
