package bankproject.entities;

import bankproject.enumerations.CountryEnum;

public class Account extends AbstractEntity {

	private Integer id;
	private String account_number;
	private Integer customer_id;
	private CountryEnum country;
	private Double solde;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String accountNumber(CountryEnum country) {

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


	


	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}


	public CountryEnum getCountry() {
		return country;
	}


	public void setCountry(CountryEnum country) {
		this.country = country;
	}
	
	public void setCountry(String country_) {

	
		switch (country_) {

		case "FRANCE":
			this.country = CountryEnum.FRANCE;
			break;
		case "BELGIQUE":
			this.country = CountryEnum.BELGIQUE;
			break;
		case "ESPAGNE":
			this.country = CountryEnum.ESPAGNE;
			break;
		case "GRANDE-BRETAGNE":
			this.country = CountryEnum.GRANDE_BRETAGNE;
			break;
		case "ALLEMAGNE":
			this.country = CountryEnum.ALLEMAGNE;
			break;
		case "PAYS_-BAS":
			this.country = CountryEnum.PAYS_BAS;
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