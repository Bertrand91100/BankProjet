package bankproject.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bankproject.entities.AbstractEntity;
import bankproject.entities.Account;
import bankproject.exceptions.SrvException;

public class SrvAccount extends AbstractService {

    private static SrvAccount INSTANCE = new SrvAccount();

	private SrvAccount() {
		setEntitySqlTable("Account");
	}

	public static SrvAccount getInstance() {
		return INSTANCE;
	}

	

	private void create(Account entity) throws SQLException {
		String sql = "INSERT INTO " + getEntitySqlTable()
				+ " (country, account_number, customer_id, solde) VALUES (?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = getDbManager().getConnection();
			ps = connection.prepareStatement(sql);

			ps.setString(1, entity.getCountry().toString());
			ps.setString(2, entity.getAccountNumber());
			ps.setString(3, entity.getCustomer_id().toString());
			ps.setString(4, entity.getSolde().toString());

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

	private void update(Account entity) throws SQLException {
		String sql = "UPDATE " + getEntitySqlTable()
				+ " SET country = ?, account_number = ?, customer_id = ?, solde = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = getDbManager().getConnection();
			ps = connection.prepareStatement(sql);

			ps.setString(1, entity.getCountry().toString());
			ps.setString(2, entity.getAccountNumber());
			ps.setString(3, entity.getCustomer_id().toString());
			ps.setString(4, entity.getSolde().toString());
			ps.setInt(5, entity.getId());

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
	
	private void delete(Account entity) throws SQLException {
		String sql = "DELETE" + getEntitySqlTable() + " WHERE id = ?";
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = getDbManager().getConnection();
			ps = connection.prepareStatement(sql);

			ps.setString(1, entity.getCountry().toString());
			ps.setString(2, entity.getAccountNumber());
			ps.setString(3, entity.getCustomer_id().toString());
			ps.setString(4, entity.getSolde().toString());
			ps.setInt(5, entity.getId());

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
	
	

	@Override
	protected Account populateEntity(ResultSet rs) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setCountry(rs.getString("country"));
		account.setAccountNumber(rs.getString("number"));
		account.setCustomer_id(rs.getInt("customer_id"));
		account.setSolde(rs.getDouble("summary"));

		return account;
	}

	@Override
	public void save(AbstractEntity entity) throws SrvException, SQLException {
		if (entity instanceof Account) {
			Account account = (Account) entity;
			if (account.getId() == null) {
				create(account);
			} else {
				update(account);
			}
		} else {
			throw new SrvException("Utilisation du mauvais service");
		}
	}

	public String createTableInDB() {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE IF NOT EXISTS Account ( ");
		sb.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sb.append("country VARCHAR(30) NOT NULL, ");
		sb.append("number VARCHAR(30) NOT NULL, ");
		sb.append("customer_id INTEGER NOT NULL, ");
		sb.append("summary DOUBLE NOT NULL ");
		sb.append(")");

		return sb.toString();
	}

	public Account get(String number_) throws Exception {

		Connection connexion = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Account result = null;

		StringBuilder query = new StringBuilder("SELECT * FROM ");
		query.append(getEntitySqlTable());
		query.append(" WHERE (number = ?)");

		try {
			connexion = getDbManager().getConnection();
			pst = connexion.prepareStatement(query.toString());
			pst.setString(1, number_);
			rs = pst.executeQuery();

			while (rs.next()) {
				result = populateEntity(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pst != null) {
				pst.close();
			}

			if (connexion != null) {
				connexion.close();
			}

		}
		return result;

	}

}