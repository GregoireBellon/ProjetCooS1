
public class Bag extends Equipment{
	
	protected int size; //size of the bag, how many object can fit in it
	
	/**
	 * A bag is instanced with a name and a max number of item
	 * @param name The name of the bag
	 * @param size The maximum number of item in the bag
	 */
	Bag(String name, int size){
		super(name);
		this.size=size;
	}
	
}
