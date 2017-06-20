package bankproject.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bankproject.entities.AbstractEntity;
import bankproject.entities.Operation;
import bankproject.exceptions.SrvException;

public class SrvOperation extends AbstractService {

	private static SrvOperation INSTANCE = new SrvOperation();

	
	private SrvOperation() {
		setEntitySqlTable("Operation");
		// (id, amount, type_operation, accountNumber, customer_id, date_operation)
		
	}

	
	public static SrvOperation getInstance() {
		return INSTANCE;
	}

	private void create(Operation entity) throws SQLException {
		String sql = "INSERT INTO " + getEntitySqlTable()
				+ " (account_number, customer_id, amount, date_operation, type_operation, ) VALUES (?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = getDbManager().getConnection();
			ps = connection.prepareStatement(sql);

			ps.setString(1, entity.getAccount_number().toString());
			ps.setString(2, entity.getCustomer_id().toString());
			ps.setString(3, entity.getAmount().toString());
			ps.setString(4, entity.getDate_Operation());
			ps.setString(5, entity.getType_operation().toString());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (ps != null) {
				ps.close();
			}

			if (connection != null) {
				connection.close();
			}
		}
	}

	// (amount, type_operation, account_number, customer_id, date, id)

	private void update(Operation entity) throws SQLException {
		String sql = "UPDATE " + getEntitySqlTable()
				+ " SET amount = ?, type_operation = ?, account_number = ?, customer_id = ?, date_operation = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = getDbManager().getConnection();
			ps = connection.prepareStatement(sql);

			ps.setString(1, entity.getAmount().toString());
			ps.setString(2, entity.getType_operation().toString());
			ps.setString(3, entity.getAccount_number().toString());
			ps.setString(4, entity.getCustomer_id().toString());
			ps.setString(5, entity.getDate_Operation());
			ps.setInt(6, entity.getId());

			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}

			if (ps != null) {
				ps.close();
			}
		}
	}

	@Override
	// (id, amount, type_operation, account_number, customer_id, date)

	protected Operation populateEntity(ResultSet rs) throws SQLException {
		Operation operation = new Operation();
		operation.setId(rs.getInt("id"));
		operation.setAmount(rs.getDouble("amount"));
		operation.setAccount_number(rs.getInt("account_number"));;
		operation.setType_operation(rs.getString("type_operation"));
		operation.setCustomer_id(rs.getInt("customer_id"));
		operation.setDate_Operation(rs.getString("date"));

		return operation;
	}

	@Override
	public void save(AbstractEntity entity) throws SrvException, SQLException {
		if (entity instanceof Operation) {
			Operation operation = (Operation) entity;
			if (operation.getId() == null) {
				create(operation);
			} else {
				update(operation);
			}
		} else {
			throw new SrvException("Utilisation du mauvais service");
		}
	}

	public void delete (Operation entity) throws SQLException {
		String sql = "DELETE" + getEntitySqlTable() + " WHERE id = ?";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = getDbManager().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, entity.getAccount_number());
			ps.setString(2, entity.getDate_Operation());
			ps.setString(3, entity.getType_operation().toString());
			ps.setInt(4, entity.getId());
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (ps != null) {
				ps.close();
			}

			if (connection != null) {
				connection.close();
			}

		}
	}

	
	public String createTableInDB() {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE IF NOT EXISTS Operation ( ");
		sb.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sb.append("amount DOUBLE NOT NULL, ");
		sb.append("type_operation VARCHAR(30) NOT NULL, ");
		sb.append("account_number INTEGER NOT NULL, ");
		sb.append("customer_id INTEGER NOT NULL, ");
		sb.append("date_operation TEXT NOT NULL ");
		sb.append(")");

		return sb.toString();
	}
}
