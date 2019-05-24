/**
 * Entity that a character can use or add to his inventory
 * 
 * @author Hugo Valadon
 * @author Grégoire Bellon
 */
public class Equipment {
	/**
	 * name of the equipment
	 */
	private String name;
	
	/**
	 * Initialize an equipment with a name
	 * @param name
	 */
	Equipment(String name){
		this.name = name;
	}
	
	/**
	 * add the equipment to his inventory
	 * @param c Character which is equiped
	 */
	public void equip(Character c) {
		
		c.equipment_list.add(this);
	
	}
	
	
	/**
	 * Use the equipment (This method is overrided by all the children)
	 * @param target
	 */
	public void use(MainCharacter target) {
		
		return;
	}
	
	/**
	 * Equip to the player, this method handle the player's bag size
	 * @param c player
	 */
	public void equip(MainCharacter c) {
		if(c.canAddEquipement()) {
			equip((Character)c);
		}
		else System.out.println("Your bag is full!");
	}

	/**
	 * return the name of the equipment
	 * @return
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
String line;

line=name;
		
		return line;

	}

}
