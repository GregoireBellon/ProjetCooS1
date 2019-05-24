
public class Equipment {
	
	private String name;
	
	Equipment(String name){
		this.name = name;
	}
	
	public void equip(Character c) {
		
		c.equipment_list.add(this);
	
	}
	
	
	
	public void use(MainCharacter target) {
		
		return;
	}
	
	
	public void equip(MainCharacter c) {

		if(c.canAddEquipement()) {
			equip((Character)c);
		}
		else System.out.println("Your bag is full!");
	}

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
