import java.util.Scanner;

/**
 * create a scanner, avoid to overload the program with to much scanners
 * Also handle the errors
 * @author Grégoire
 *
 */
public class ScannerEntry {

	public static Scanner sc = new Scanner(System.in);
/**
 * Scan an int
 * @return int that the player has entered
 */
	public static int getInt() {
		try {
			return sc.nextInt();
		} catch (java.lang.IllegalStateException e) {
			Scanner sc2 = new Scanner(System.in);
			int result = sc2.nextInt();
			sc2.close();

			return result;
		}
	}
	
	/**
	 * Scan a string
	 * @return string that the player has entered
	 */
	public static String getString() {
		try {
			return sc.nextLine();
		} catch (java.lang.IllegalStateException e) {
			
			Scanner sc2 = new Scanner(System.in); //second try if the player enter a bad value (it often save the day, I don't know why)
			String result = sc2.nextLine();
			sc2.close();

			return result;
		}
	}
/**
 * close the scanner
 */
	public static void close() {
		sc.close();
	}
}
