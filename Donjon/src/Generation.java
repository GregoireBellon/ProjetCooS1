import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Generation {

	public static Character generateCharacter() throws IOException {
		
		
		FileReader read_file = new FileReader(Main.bestiary_txt);
		BufferedReader read_buff = new BufferedReader(read_file);
		String name="";
		String line;
		double rand;
		boolean loop_over=false;
		
		while(!loop_over) {
			read_buff.mark(1000);
			  while(read_buff.ready()){
				  line=read_buff.readLine();
				  rand = Math.random();
				  if(rand<(0.03571428571)) { //this is 1/19 because they are 19 weapons
					  name=line;
			//		  System.out.println(line);
					  loop_over=true;
					  break;
				  }
			  }
			  
			  read_buff.reset();
			
		  }
		
		read_buff.close();
		read_file.close();
		
		double hp = 60 + Main.progression*0.60;
		
		Character out = new Character(name, (int) hp, generateWeapon(true), Main.place);
		
		System.out.println(out);
		
		return out;

		
		
	}
	
	public static Weapon generateWeapon(boolean ennemy) throws IOException {
		double progression;
		if(ennemy) progression = (Main.progression*0.60);
		else progression = Main.progression;
		
		
		FileReader read_file = new FileReader(Main.weapons_txt);
		BufferedReader read_buff = new BufferedReader(read_file);
		String name="";
		String line;
		double rand;
		boolean loop_over=false;
		
		while(!loop_over) {
			read_buff.mark(1000);
			  while(read_buff.ready()){
				  line=read_buff.readLine();
				  rand = Math.random();
				  if(rand<(0.05263157894)) { //this is 1/19 because they are 19 weapons
					  name=line;
			//		  System.out.println(line);
					  loop_over=true;
					  break;
				  }
			  }
			  
			  read_buff.reset();
			
		  }
		
		read_buff.close();
		read_file.close();
		
		//System.out.println("terminé");
		double precision = 60 + (Math.random()*20)-10;
		double pa =progression+(2*(progression/(Math.random()*3+1)));
		System.out.println();
		Weapon out = new Weapon(name, (int) pa , (int) precision);
		
		return out;
		
	}
	
	public static Equipment generateStuff() throws IOException{
		
		double rand = Math.random();
		
		if(rand<0.3) {
			
			// potion
			
		}
		else if(rand<0.5) {
			
			Bag bout = new Bag(, size)			
		}
		else if(rand>0.5) {
			Weapon wout = generateWeapon(false);
			return wout;
		}
		
		
		
		return null;
		
	}
	
	
}
