package org.bank.kata;

import java.math.BigDecimal;

import org.bank.kata.pojo.Account;
import org.bank.kata.utils.Statement;

/**
 * 
 * @author Roland B.
 * This main test the feature !
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final Account account;

		account = new Account(new BigDecimal(197));
		account.deposit(new BigDecimal(3));
		account.withdrawal(new BigDecimal(4));
		account.withdrawal(new BigDecimal(6));
		account.deposit(new BigDecimal(50));
		account.withdrawal(new BigDecimal(20));
		account.deposit(new BigDecimal(15));
		Statement.printStatement(account);
    }
}
