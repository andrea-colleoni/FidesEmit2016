/**
 *
 * @author aculnaig
 *
 */

/*
 * Apre un URL, associa la pagina HTML corrispendente,
 * legge la pagina riga per riga e stampa la riga in STDOUT. 
 *
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class AppNet {
        
	public static void main(String[] args) {
	   
	    try {	
	        URL urlPage = new URL("http://www.google.it");
                InputStream in = urlPage.openStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;

	        while ((line = br.readLine()) != null)
                    System.out.println(line);
                
               	in.close();	
	        br.close();

	    } catch (MalformedURLException mue) {
		    mue.printStackTrace();
            } catch (IOException ioe) {
		    ioe.printStackTrace();
            }

	}
}
