/**
 * Entity that heal the player when used
 * 
 * @author Hugo Valadon
 * @author Grégoire Bellon
 *
 */
public class Potion extends Equipment {
/**
 * Define the Hps that will be given to the player when he use it
 */
	private int value = 0;

	Potion(String name, int value) {
		super(name);
		this.value = value;
	}

	/**
	 * Drink the potion (add hps to the player) and remove if from the inventory 
	 */
	@Override
	public void use(MainCharacter target) {

		target.addHp(value);
		target.equipment_list.remove(this);
		
		return;
		
	}
	
	/**
	 * return the name and the value of the potion by a String
	 */
	@Override
	public String toString() {

		String out = super.getName()+" : +"+value+"hp";
		
		return out;
	}
	
	

}
