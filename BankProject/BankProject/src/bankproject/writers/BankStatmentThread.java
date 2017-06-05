package bankproject.writers;

public class BankStatmentThread extends Thread {
	


	int time = 60000 * 13; // Conversion de 13 minutes en millisecondes
	
	public static void main(String[] args) {

		BankStatmentThread bst = new BankStatmentThread("C");
	}

	public BankStatmentThread(String name) {
		super(name);
		System.out.println("statut du thread " + name + " = " + this.getState());
		this.start();
		System.out.println("statut du thread " + name + " = " + this.getState());
	}
	
		public void run() {

		while (true) { // TODO Ajouter une condition de sortie

			FileCountryWriter fcw = new FileCountryWriter();

			FileDebitorsWriter fdebw = new FileDebitorsWriter();

			FileCreditorsWriter fcrew = new FileCreditorsWriter();

			try {
				Thread.sleep(time);
			} catch (InterruptedException ie) {
				continue; // Recommencer en début de boucle
			}
		}
	}

}