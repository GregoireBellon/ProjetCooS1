import java.util.Scanner;

public class ScannerEntry {

	public static Scanner sc = new Scanner(System.in);

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

	public static void close() {
		sc.close();
	}
}
