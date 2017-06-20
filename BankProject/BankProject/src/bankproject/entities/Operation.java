package bankproject.entities;

import bankproject.enumerations.TypeOperationEnum;

public class Operation extends AbstractEntity {

	private Integer id;
	private Integer account_number;
	private Integer customer_id;
	private TypeOperationEnum type_operation;
	private String date_Operation;
	private Double amount;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	public Integer getAccount_number() {
		return account_number;
	}

	public void setAccount_number(Integer account_number) {
		this.account_number = account_number;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}


	public TypeOperationEnum getType_operation() {
		return type_operation;
	}




	public void setType_operation(String nature_operation) {

		switch (nature_operation) {

		case "CREDIT":
			this.type_operation = TypeOperationEnum.CREDIT;
			break;
			
		case "DEBIT":
			this.type_operation = TypeOperationEnum.DEBIT;
			break;}
		
		}




	public String getDate_Operation() {
		return date_Operation;
	}




	public void setDate_Operation(String date_Operation) {
		this.date_Operation = date_Operation;
	}




	public Double getAmount() {
		return amount;
	}




	public void setAmount(Double amount) {
		this.amount = amount;
	}




	
	

}
