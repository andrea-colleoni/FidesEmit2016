import java.util.ArrayList;
import java.util.List;

public class EsempiLambdaCollections {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		lista.add("italia");
		lista.add("francia");
		lista.add("germania");
		lista.add("svizzera");
		lista.add("austria");
		lista.add("australia");
		lista.add("svezia");
		lista.add("Spagna");
		
		lista.forEach(paese -> {
			System.out.println(paese);
			//...
			//..
		});
		
		// cerco paesi che iniziaano con s
		List<String> paesiConS = new ArrayList<>();
 		for(String s : lista) {
 			if (s.toLowerCase().charAt(0) == 's') {
 				paesiConS.add(s);
 				System.out.println(s);
 			}
 		}
 		System.out.println("**************");
 		lista.stream()
 			.filter(s -> s.toLowerCase().charAt(0) == 's')
 			.forEach(s -> System.out.println(s));
 		
	}

}
