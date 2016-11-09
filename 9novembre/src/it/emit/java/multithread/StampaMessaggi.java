package it.emit.java.multithread;

public class StampaMessaggi {

	public void messaggio1()  {
		try {
			System.out.println(System.currentTimeMillis() + " => Messaggio 1 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
			System.out.println(System.currentTimeMillis() + " => Messaggio 1.1 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
			System.out.println(System.currentTimeMillis() + " => Messaggio 1.2 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
	}

	public void messaggio2() {
		try {
			System.out.println(System.currentTimeMillis() + " => Messaggio 2 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
			System.out.println(System.currentTimeMillis() + " => Messaggio 2.1 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
			System.out.println(System.currentTimeMillis() + " => Messaggio 2.2 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
			System.out.println(System.currentTimeMillis() + " => Messaggio 2.3 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
			System.out.println(System.currentTimeMillis() + " => Messaggio 2.4 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
	}

	public void messaggio3() {
		try {
			System.out.println(System.currentTimeMillis() + " => Messaggio 3 (" + Thread.currentThread().getName() + ")");
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
	}
}
