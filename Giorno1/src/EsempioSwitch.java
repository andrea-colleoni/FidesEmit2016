
public class EsempioSwitch {

	public static void main(String[] args) {
		int limiteInferiore = 5;
		int limiteSuperiore = 10;
		double casuale = Math.random();
		int casualeIntero = 
				(int)(casuale * (limiteSuperiore - limiteInferiore) + 
						limiteInferiore);
		System.out.println(casualeIntero);
		
		switch(casualeIntero) {
		case 5:
		case 6:
		case 7:			
			System.out.println("CINQUE/SEI/SETTE");
			break;
		case 8:
			System.out.println("OTTO");
			break;
		case 9:
			System.out.println("NOVE");
			break;
		case 10:
			System.out.println("DIECI");
			break;
		default:
			System.out.println("IMPOSSIBILE!!");
		}
	}

}
