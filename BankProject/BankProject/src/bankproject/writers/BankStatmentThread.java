package bankproject.writers;

public class BankStatmentThread extends Thread {
	

	int time = 60 * 1000 * 13; // Conversion de 13 minutes en millisecondes
	
	public static void main(String[] args) {

		new BankStatmentThread("C");
	}

	public BankStatmentThread(String name) {
		super(name);
		System.out.println("statut du thread " + name + " = " + this.getState());
		this.start();
		System.out.println("statut du thread " + name + " = " + this.getState());
	}
	
		public void run() {

		while (true) {

			new CountryFileWriter();

			new DebitorsFileWriter();

			new CreditorsFileWriter();

			try {
				Thread.sleep(time);
			} catch (InterruptedException ie) {
				continue;
			}
		}
	}

}