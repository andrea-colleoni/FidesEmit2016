/**
 *
 * @author aculnaig
 *
 */

/* Per compilare la seguente classe, eseguire il comando da terminale: 
 *
 * javac -g -cp ../lib/gson-2.3.1.jar Studente.java Scuola2.java 
 * 
 */

/* 
 * In questo esempio, viene usata la GSON API di Google
 * per serializzare/deserializzare oggetti Java in e da file JSON.
 *
 */

import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;

public class Scuola2 {

    public static void main(String[] args) {
        
        List<Studente> ls = new ArrayList<Studente>();

	Studente harry = new Studente();
        harry.setMatricola(31);
	harry.setNome("Harry");
	harry.setCognome("Potter");
        ls.add(harry);   

        Studente hermione = new Studente();	
	hermione.setMatricola(32);
	hermione.setNome("Hermione");
	hermione.setCognome("Granger");
	ls.add(hermione);  

        Studente ronald = new Studente();	
	ronald.setMatricola(33);
	ronald.setNome("Ronald");
	ronald.setCognome("Weasley");
	ls.add(ronald);

	Gson gson = new Gson();
	String gryffindorJson = gson.toJson(ls);

	System.out.println("Gryffindor\n" + gryffindorJson);

	}
}
