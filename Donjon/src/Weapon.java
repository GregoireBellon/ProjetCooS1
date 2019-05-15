
public class Weapon extends Equipment {

	protected int pa;
	protected int precision; // précision de l'arme

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
