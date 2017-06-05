package bankproject.entities;

import bankproject.enumerations.TypeOperationEnum;

public class Operation extends AbstractEntity {

	private Integer id;
	private Double amount;
	private TypeOperationEnum type_operation;
	private Integer accountNumber;
	private Integer customer_id;
	private String date_Operation;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TypeOperationEnum getType_operation() {
		return type_operation;
	}

	public void setType_operation(TypeOperationEnum type_operation) {
		this.type_operation = type_operation;
	}

	public void setType_operation(String nature_operation) {

		switch (nature_operation) {

		case "CREDIT":
			this.type_operation = TypeOperationEnum.CREDIT;
			break;
			
		case "DEBIT":
			this.type_operation = TypeOperationEnum.DEBIT;
			break;
		
		}
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getDate_Operation() {
		return date_Operation;
	}

	public void setDate_Operation(String date_Operation) {
		this.date_Operation = date_Operation;
	}


	
}