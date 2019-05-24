
public class Weapon extends Equipment {

	protected int pa;
	protected int precision; // precision of the weapon


	
	/**
	 * A weapon is instanced with a name and a set number of attack points
	 * @param name The name of the weapon
	 * @param pa The number of attack points
	 */
	Weapon(String name, int pa, int precision) { //
		super(name);
		this.pa = pa;
		this.precision=precision;
	}

	public int getPa() {
		return pa;
	}

	@Override
	public String toString() {

		return super.getName() + "  //  Damages :" + pa;
	}

	public int getPrecision() {
		return precision;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	@Override
	public void use(MainCharacter target) {
		if(target.equipment_list.get(0).equals(this)) {
			System.out.println("This weapon is already equiped !");
		return;
		}
	int index =target.equipment_list.indexOf(this);
	Weapon transfert = (Weapon) target.equipment_list.get(0);
	target.equipment_list.add(0, this);
	target.equipment_list.add(index, transfert);
	
	System.out.println(super.getName()+" equiped");
	}
		
		
	}
	
