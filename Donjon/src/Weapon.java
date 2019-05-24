import java.util.Collections;

/** 
 * Entity used by a character that deals damages to an other one.
 * 
 * @author Grégoire
 * @author Hugo
 *
 */
public class Weapon extends Equipment {

	/**
	 * Define damages that an attack will deal
	 */
	protected int pa;
	/**
	 * define the chances that the player has to dodge when he's attacked with this weapon
	 */
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

	/**
	 * 
	 * @return Attack points
	 */
	public int getPa() {
		return pa;
	}

	@Override
	public String toString() {

		return super.getName() + "  //  Damages :" + pa;
	}
/**
 * 
 * @return Precision of the weapon
 */
	public int getPrecision() {
		return precision;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	/**
	 *Swap the first weapon (in position 0) with this one. This weapon become the one that the player use to hit ennemies
	 * 
	 * @param target player 
	 * 
	 */
	@Override
	public void use(MainCharacter target) {
		if(target.equipment_list.get(0).equals(this)) {
			System.out.println("This weapon is already equiped !");
		return;
		}
	int index =target.equipment_list.indexOf(this);
	//Weapon transfert = (Weapon) target.equipment_list.get(0);
	Collections.swap(target.equipment_list, 0, index);
	//target.equipment_list.add(0, this);
	//target.equipment_list.add(index, transfert);
	
	System.out.println(super.getName()+" equiped");
	
	
	}
		
		
	}
	
