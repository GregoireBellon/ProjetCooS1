
public class Weapon extends Equipment {

	protected int pa;
	
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
		
		return super.getName()+"  //  Damages :"+pa;
	}

}
