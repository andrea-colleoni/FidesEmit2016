package it.emit.java.multithread;

public class Programma {

	public static void main(String[] args) throws InterruptedException {
		StampaMessaggi sm = new StampaMessaggi();
		// anonymous inner class
		// closure
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				sm.messaggio2();
			}
		});
		
		// la stessa cosa scritta sopra, ma usando Lambda expression
		Thread t2 = new Thread(() -> sm.messaggio2());
		Thread t3 = new Thread(() -> {
				sm.messaggio2();
			}
		);
		t1.setName("primo");
		t2.setName("secondo");
		t3.setName("terzo");
		
		// al posto di fare sm.messaggio1();
		t1.start();
		t2.start();
		t3.start();
//		
//		sm.messaggio2();
//		sm.messaggio3();

	}

}
