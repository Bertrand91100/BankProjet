package bankproject;

import java.sql.SQLException;


import bankproject.readers.AccountCustomerThread;
import bankproject.readers.OperationThread;
import bankproject.writers.BankStatmentThread;

public class Main {

	public static void main(String[] args) throws SQLException {
		
				
		AccountCustomerThread act = new AccountCustomerThread ("A");
				
		OperationThread ot = new OperationThread("B");
				
		BankStatmentThread bst = new BankStatmentThread("C");

		
	}

}