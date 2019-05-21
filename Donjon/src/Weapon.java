
public class Weapon extends Equipment {

	protected int pa;
	protected int precision; // précision de l'arme

	
	/**
	 * A weapon is instanced with a name and a set number of attack points
	 * @param name The name of the weapon
	 * @param pa The number of attack points
	 */
	Weapon(String name, int pa) {
		super(name);
		this.pa = pa;
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

}