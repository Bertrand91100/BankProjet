package bankproject.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bankproject.entities.AbstractEntity;
import bankproject.entities.Account;
import bankproject.enumerations.CountryEnum;
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
			ps.setString(2, entity.getAccount_number());
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
			ps.setString(2, entity.getAccount_number());
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
			ps.setString(2, entity.getAccount_number());
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
		account.setAccount_number(rs.getString("number"));
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
		sb.append("account_number VARCHAR(30) NOT NULL, ");
		sb.append("customer_id INTEGER NOT NULL, ");
		sb.append(")");

		return sb.toString();
	}
	
	public String dropTableInDB() {
		StringBuilder sb = new StringBuilder();
		sb.append("DROP TABLE IF EXISTS Account");

		return sb.toString();
	}
	

	public Account getByAccountNumberAndCountry(Integer accountNumber, CountryEnum country) throws Exception {
		Connection connection = null;
		PreparedStatement pst =  null;
		Account account = null;
		String sql = "SELECT * FROM " + getEntitySqlTable() + " WHERE country = ? AND account_number = ? ";
		
		try {
			connection = getDbManager().getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, country.name());
			pst.setInt(2, accountNumber);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				account = populateEntity(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			if (pst != null) {
				pst.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		}
		
		return account;
	}
}