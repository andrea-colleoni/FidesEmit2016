/**
 * @author aculnaig
 *
 */

public class App {
	
	public static void main(String args[]) {
		
		StudenteDAO dao = new StudenteDAO();
		
		// Potete sempre lasciare setMatricola(0) dato che il campo matricola è autoincrement
		/*Studente harry = new Studente();
		harry.setMatricola(0);
		harry.setNome("Harry");
		harry.setCognome("Potter");
		
		dao.inserisci(harry);*/
                
		// Presume che nel vostro database scuola ci sia uno studente con matricola uguale a 10
		Studente harry = dao.studentePerMatricola(10);

		System.out.println(harry.toString());
	}

}
