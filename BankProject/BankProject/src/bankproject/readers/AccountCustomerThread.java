package bankproject.readers;

public class AccountCustomerThread extends Thread {


	int time = 7 * 60 * 1000; // Conversion du temps de 7 minutes en millisecondes

	public static void main(String[] args) {

		new AccountCustomerThread("A");
	}


	public AccountCustomerThread(String name) {
		super(name);
		System.out.println("statut du thread " + name + " = " + this.getState());
		this.start();
		System.out.println("statut du thread " + name + " = " + this.getState());
	}


	public void run() {

		while (true) {

			new AccountCustomerReader();

			try {
				Thread.sleep(time);
			} catch (InterruptedException ie) {
				continue; 
			}
		}

	}

}