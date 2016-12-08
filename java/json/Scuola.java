/**
 * @author aculnaig
 *
 */

/* Crea un JSON Object, lo popula e lo scrive su un file chiamato scuola.json */

/* Per compilare il programma da terminale eseguite il seguente comando: */
/* javac -g -cp javax.json-1.0.4.jar *.java */

/* Per eseguire il programma da terminale lanciate il seguente comando: */
/* java -cp .:javax.json-1.0.4.jar Scuola */

/* NOTA: si presume che il file javax.json-1.0.4.jar 
 *       si trovi nella stessa cartella in cui compilate le classi .java 
 *       Per sicurezza, il file javax.json-1.0.4.jar è già presente nella cartella */


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

	/* Java to JSON Object */
	JsonObject studente = Json.createObjectBuilder()
		              .add("matricola", 298)
			      .add("nome", "Harry")
			      .add("cognome", "Potter")
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
