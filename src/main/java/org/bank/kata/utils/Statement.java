package org.bank.kata.utils;

import java.math.BigDecimal;
import java.util.Date;

import org.bank.kata.pojo.Account;

/**
 * This class will print the statement
 * @author Roland B.
 * 
 */
public class Statement {

	/**
	 * This method print the statement
	 * @param account
	 */
	public static void printStatement(final Account account) {
		System.out.println("- - - - - - STATEMENT - - - - - -");
		System.out.println(getAccountCreationLine(account.getCreationDate()));
		account.getLstOperations().stream().forEach(System.out::println);
		System.out.println(getBalanceLine(account.getBalance()));
		System.out.println("- - - - - -    END    - - - - - -");
	}
	

	/**
	 * This method return the line of the creation date
	 * @return
	 */
	private static String getAccountCreationLine(final Date creationDate) {
		final StringBuilder strBld;

		strBld = new StringBuilder();
		strBld.append("[");
		strBld.append(creationDate);
		strBld.append("] Account created !");
		return strBld.toString();
	}
	
	/**
	 * This method return the balance line
	 * @return
	 */
	private static String getBalanceLine(final BigDecimal balance) {
		final StringBuilder strBld;

		strBld = new StringBuilder();
		strBld.append("[");
		strBld.append(new Date());
		strBld.append("] Balance : ");
		strBld.append(balance);
		return strBld.toString();
	}
	
}
