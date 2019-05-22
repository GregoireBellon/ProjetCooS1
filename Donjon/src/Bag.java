
public class Bag extends Equipment{
	
	protected int size; //size of the bag
	
	Bag(String name, int size){
		super(name);
		this.size=size;
	}
	
	@Override
	public String toString() {
		
		String out;
		
		out = super.getName()+" : "+size+" slots";
		
		return out;
	}
	
}
