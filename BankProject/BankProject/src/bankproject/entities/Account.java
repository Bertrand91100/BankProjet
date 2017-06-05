package bankproject.entities;

import bankproject.enumerations.PaysEnum;

public class Account extends AbstractEntity {

	private Integer id;
	private String accountNumber;
	private Integer customer_id;
	private PaysEnum country;
	private Double solde;
	

	public String accountNumber(PaysEnum country) {

		StringBuilder sb = new StringBuilder();
		int digit, i;

		switch (country) {

		
		case FRANCE:
			sb.append("FR");
			break;
		case BELGIQUE:
			sb.append("BE");
			break;
		case ESPAGNE:
			sb.append("ES");
			break;
		case GRANDE_BRETAGNE:
			sb.append("GB");
			break;
		case ALLEMAGNE:
			sb.append("DE");
			break;
		case PAYS_BAS:
			sb.append("NL");
			break;
		}

		for (i = 1; i < 7; i++) {

			digit = (int) (Math.random() * 10);
			sb.append(digit);

		}

		return sb.toString();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Integer getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}


	public PaysEnum getCountry() {
		return country;
	}


	public void setCountry(PaysEnum country) {
		this.country = country;
	}
	
	public void setCountry(String country_) {

	
		switch (country_) {

		case "FRANCE":
			this.country = PaysEnum.FRANCE;
			break;
		case "BELGIQUE":
			this.country = PaysEnum.BELGIQUE;
			break;
		case "ESPAGNE":
			this.country = PaysEnum.ESPAGNE;
			break;
		case "GRANDE-BRETAGNE":
			this.country = PaysEnum.GRANDE_BRETAGNE;
			break;
		case "ALLEMAGNE":
			this.country = PaysEnum.ALLEMAGNE;
			break;
		case "PAYS_-BAS":
			this.country = PaysEnum.PAYS_BAS;
			break;
		
		}	
		
		}

	public Double getSolde() {
		return solde;
	}


	public void setSolde(Double solde) {
		this.solde = solde;
	}

	
	

}