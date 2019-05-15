
public class Weapon extends Equipment {

	protected int pa;
	
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
