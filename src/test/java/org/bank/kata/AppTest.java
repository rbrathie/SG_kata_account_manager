package org.bank.kata;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.bank.kata.enums.OperationType;
import org.bank.kata.pojo.Account;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void testInitialDeposit() {
    	final Account account;
    	final BigDecimal initialDeposit = new BigDecimal(197);
    	
    	account = new Account(initialDeposit);

    	assertTrue(account.getBalance().equals(initialDeposit));
    }
    
    @Test
    public void testBalanceAfterDeposit() {
    	final Account account;
    	final BigDecimal deposit = new BigDecimal(197);
    	
    	account = new Account(new BigDecimal(0));
    	account.deposit(deposit);

    	assertTrue(account.getBalance().equals(deposit));
    }
       
    @Test
    public void testDepositOperation() {
    	final Account account;
    	final BigDecimal deposit = new BigDecimal(197);
    	
    	account = new Account(new BigDecimal(0));
    	account.deposit(deposit);

    	assertTrue(account.getLstOperations().size() == 1);
    	assertTrue(account.getLstOperations().stream().filter(p -> p.getOperationType().equals(OperationType.DEPOSIT)).count() == 1);
    	assertTrue(account.getLstOperations().get(0).getValue().equals(deposit));
    }
    
    
    @Test
    public void testBalanceAfterWithDrawal() {
    	final Account account;
    	final BigDecimal balance = new BigDecimal(197);
    	
    	account = new Account(new BigDecimal(200));
    	account.withdrawal(new BigDecimal(3));

    	assertTrue(account.getBalance().equals(balance));
    }
    
    @Test
    public void testWithDrawalOperation() {
    	final Account account;
    	final BigDecimal withDrawal = new BigDecimal(3);
    	
    	account = new Account(new BigDecimal(200));
    	account.withdrawal(withDrawal);
    	
    	assertTrue(account.getLstOperations().size() == 2);
    	assertTrue(account.getLstOperations().stream().filter(p -> p.getOperationType().equals(OperationType.WITHDRAWAL)).count() == 1);
    	assertTrue(account.getLstOperations().get(1).getValue().equals(withDrawal));
    }

    @Test
    public void testListOperations() {
    	final Account account;

    	account = new Account(new BigDecimal(0));
    	account.deposit(new BigDecimal(20));
    	account.deposit(new BigDecimal(30));
    	account.withdrawal(new BigDecimal(3));

    	assertTrue(account.getLstOperations().stream().filter(p -> p.getOperationType().equals(OperationType.DEPOSIT)).count() == 2);
    	assertTrue(account.getLstOperations().stream().filter(p -> p.getOperationType().equals(OperationType.WITHDRAWAL)).count() == 1);
    }
}
