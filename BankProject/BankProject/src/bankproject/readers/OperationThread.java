package bankproject.readers;

public class OperationThread extends Thread {

	int time = 60 * 1000 * 11; // conversion du temps de 11 minutes en millisecondes


	public static void main(String[] args) {

		OperationThread ot = new OperationThread("B");
	}



	public OperationThread(String name) {
		super(name);
		System.out.println("statut du thread " + name + " = " + this.getState());
		this.start();
		System.out.println("statut du thread " + name + " = " + this.getState());
	}


	public void run() {

		while (true) {

			OperationReader or = new OperationReader();

			try {
				Thread.sleep(time);
			} catch (InterruptedException ie) {
				continue; 
		}

	}
}
}