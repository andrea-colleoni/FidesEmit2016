/**
 * @author aculnaig
 *
 */

/* Crea un JSON Object, lo popula e lo scrive su un file chiamato scuola.json */

/* Per compilare il programma da terminale eseguite il seguente comando: */
/* javac -g -cp javax.json-1.0.4.jar *.java */

/* Per eseguire il programma da terminale lanciate il seguente comando: */
/* java -cp .:javax.json-1.0.4.jar Scuola */


import java.io.FileWriter;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Scuola {
    
    public static void main(String args[]) {

	/* JSON Object
	 *
	 * {
	 *   "matricola" : 298,
	 *   "nome" : "Harry",
	 *   "cognome" : "Potter"
	 * }
	 *
	 * /

        /* Istanziamo un nuovo Studente */
	Studente s = new Studente();
	s.setMatricola(31);
	s.setNome("Harry");
	s.setCognome("Potter");

	/* Java to JSON Object */
	JsonObject studente = Json.createObjectBuilder()
		              .add("matricola", s.getMatricola())
			      .add("nome", s.getNome())
			      .add("cognome", s.getCognome())
			      .build();

        /* Creiamo un JsonWriter per scrivere il JSON Object su un file di output */
        try {
		JsonWriter jw = Json.createWriter(new FileWriter("scuola.json"));
	        jw.writeObject(studente);
                jw.close();	
	} catch (IOException ioe) {
		ioe.printStackTrace();
	}

	System.out.println("Struttura oggetto JSON appena creato\n\n" + studente.toString());
    }
} 
