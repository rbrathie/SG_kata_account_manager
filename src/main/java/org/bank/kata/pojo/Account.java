package org.bank.kata.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bank.kata.enums.OperationType;


/**
 * @author Roland B.
 * This class represent an account of a customer !
 */
public class Account {

	/**
	 * Balance Available
	 */
	private BigDecimal balance;
	
	/**
	 * Creation Date
	 */
	private Date creationDate;
	
	/**
	 * List of Operations
	 */
	private List<Operation> lstOperations;
	

	/**
	 * Constructor without deposit
	 */
	public Account() {
		this(new BigDecimal(0));
	}
	
	/**
	 * Constructor with initital deposit
	 * @param initialDeposit
	 */
	public Account(final BigDecimal initialDeposit) {
		
		this.balance = new BigDecimal(0);
		this.creationDate = new Date();
		this.lstOperations = new ArrayList<>();
		deposit(initialDeposit);
	}

	/**
	 * This method execute the deposit
	 * @param depositAmount
	 */
	public void deposit(final BigDecimal depositAmount) {
		if (depositAmount.doubleValue() > 0) {
			lstOperations.add(new Operation(depositAmount, OperationType.DEPOSIT));
			this.balance = this.balance.add(depositAmount);
		}
	}

	/**
	 * This method excute a withdrawal
	 * @param withdrawalAmount
	 */
	public void withdrawal(final BigDecimal withdrawalAmount) {
		if (this.balance.compareTo(withdrawalAmount) > 0) {
			lstOperations.add(new Operation(withdrawalAmount, OperationType.WITHDRAWAL));
			this.balance = this.balance.subtract(withdrawalAmount);
		}
		
	}

	public final BigDecimal getBalance() {
		return balance;
	}

	public final Date getCreationDate() {
		return creationDate;
	}

	public final List<Operation> getLstOperations() {
		return lstOperations;
	}
}
