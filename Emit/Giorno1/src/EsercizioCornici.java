
public class EsercizioCornici {

	public static void main(String[] args) {
		int n = 5;
		
		for (int j = 1; j < n * 2; j++) {
			for (int i = 1; i < n * 2; i++) {
				if (i < j)
					System.out.print(i);
				else System.out.print(j);
			}
			System.out.println("\n");
		}
	}
}
