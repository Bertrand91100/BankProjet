package bankproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import bankproject.readers.AccountCustomerThread;
import bankproject.readers.OperationThread;
import bankproject.services.SQLiteManager;
import bankproject.services.SrvAccount;
import bankproject.services.SrvCustomer;
import bankproject.services.SrvOperation;
import bankproject.writers.BankStatmentThread;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		SrvAccount srvAccount = SrvAccount.getInstance();
		srvAccount.setDbManager(SQLiteManager.getInstance());
		Connection connection = srvAccount.getDbManager().getConnection();
		Statement st1 = connection.createStatement();
		st1.execute(srvAccount.createTableInDB());
		connection.close();
		
		SrvCustomer srvCustomer = SrvCustomer.getInstance();
		srvCustomer.setDbManager(SQLiteManager.getInstance());
		Connection connection1 = srvCustomer.getDbManager().getConnection();
		Statement st = connection1.createStatement();
		st.execute(srvCustomer.createTableInDB());
		connection1.close();
		
		SrvOperation srvOperation = SrvOperation.getInstance();
		srvOperation.setDbManager(SQLiteManager.getInstance());
		Connection connection2 = srvOperation.getDbManager().getConnection();
		Statement st2 = connection2.createStatement();
		st2.execute(srvOperation.createTableInDB());
		connection2.close();
		
		// Lancement des Threads
		
		AccountCustomerThread act = new AccountCustomerThread ("A");
				
		OperationThread ot = new OperationThread("B");
				
		BankStatmentThread bst = new BankStatmentThread("C");

		
	}

}