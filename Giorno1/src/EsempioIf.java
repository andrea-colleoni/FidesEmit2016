
public class EsempioIf {

	public static void main(String[] args) {
		int numero = 13;
		
		// resto pu� valere 1 o 0
		// 1 se il numero � dispari, 0 se � pari
		int resto = numero % 2;
		
		if (resto == 1) {
			System.out.println("DISPARI");
		} else {
			System.out.println("PARI");
		}

	}

}
