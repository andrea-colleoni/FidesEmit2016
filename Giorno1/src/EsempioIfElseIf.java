
public class EsempioIfElseIf {

	public static void main(String[] args) {
		int limiteInferiore = 5;
		int limiteSuperiore = 10;
		double casuale = Math.random();
		int casualeIntero = 
				(int)(casuale * (limiteSuperiore - limiteInferiore) + 
						limiteInferiore);
		System.out.println(casualeIntero);
		if (casualeIntero == 5) {
			System.out.println("CINQUE");
		} else if (casualeIntero == 6) {
			System.out.println("SEI");
		} else if (casualeIntero == 7) {
			System.out.println("SETTE");
		} else if (casualeIntero == 8) {
			System.out.println("OTTO");
		} else if (casualeIntero == 9) {
			System.out.println("NOVE");
		} else if (casualeIntero == 10) {
			System.out.println("DIECI");
		} else {
			System.out.println("IMPOSSIBILE!!");
		}
	}

}
