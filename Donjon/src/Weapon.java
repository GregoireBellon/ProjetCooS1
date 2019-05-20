
public class Weapon extends Equipment {

	protected int pa;
	protected int precision; // precision of the weapon

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

}
