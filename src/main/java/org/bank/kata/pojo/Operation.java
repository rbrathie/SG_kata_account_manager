package org.bank.kata.pojo;

import java.math.BigDecimal;
import java.util.Date;

import org.bank.kata.enums.OperationType;



/**
 * @author Roland B.
 * This class represent an operation,
 * specifically deposit and withdrawal.
 */
public class Operation {

	/**
	 * Value of the operation
	 */
	private final BigDecimal value;
	
	/**
	 * Operation Date
	 */
	private final Date operationDate;

	/**
	 * Operation type
	 */
	private final OperationType operationType;
	
	
	/**
	 * Constructor
	 * @param value
	 * @param operationType
	 */
	public Operation(final BigDecimal value, final OperationType operationType) {
		this.operationDate = new Date();
		this.value = value;
		this.operationType = operationType;
	}

	public final BigDecimal getValue() {
		return value;
	}

	public final Date getOperationDate() {
		return operationDate;
	}

	public final OperationType getOperationType() {
		return operationType;
	}
	
	@Override
	public String toString() {
		final StringBuilder strbld;

		strbld = new StringBuilder();
		strbld.append("[");
		strbld.append(this.getOperationDate());
		strbld.append("] ");
		strbld.append(this.getOperationType());
		strbld.append(" :  ");
		strbld.append(this.value);
		return strbld.toString();
	}
}
