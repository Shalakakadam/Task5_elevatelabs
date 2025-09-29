package com.Shalaka.Internship;

//Base class

class Bankaccount{
	protected String bankholder;
	protected double balance;
	
	public Bankaccount(String bankholder,double balance) {
		this.bankholder=bankholder;
		this.balance=balance;
	}
	
	public void deposit(double amount){
		balance+= amount;
		System.out.println(bankholder+" your amount is been deposited, Your Balance is: "+balance);
	}
	
	public void withdrawal(double amount) {
		if(amount<balance) {
			balance-= amount;
			System.out.println(bankholder+" your amount is been withdrawed, Your Balance is: "+balance);	
			}
	}
	
	public void displayaccount() {
		System.out.println(bankholder+" your balance is: "+balance);
	}
}

class savingaccount extends Bankaccount{
	private double minbalance = 500;
	
	public savingaccount(String bankholder,double balance) {
		super(bankholder,balance);
	}
	
	@Override
	public void withdrawal(double amount) {
		if(balance-amount>=minbalance) {
			balance-= amount;
			System.out.println(amount+" withdrawn from Savings. Current Balance is: "+balance);
		}else {
			System.out.println("Withdrawal denied! Minimum balance of "+minbalance+" required.");
		}
	}
	
}


class currentaccount extends Bankaccount{
	private double overdraftlimit = 1000;
	
	public currentaccount(String bankholder,double balance) {
		super(bankholder,balance);
	}
	
	@Override
	public void withdrawal(double amount) {
		if(amount<=balance+overdraftlimit) {
			balance-= amount;
			System.out.println(amount+" withdrawn from current Account. Current Balance is: "+balance);
		}else {
			System.out.println("overdraftlimit exceeded");
		}
	}
}

public class Task5_bank {
	public static void main(String[] args) {
		Bankaccount acc1 = new savingaccount("Shalaka",3000);
		Bankaccount acc2 = new currentaccount("Druvi",4000);
		
		acc1.deposit(700);
		acc1.withdrawal(3400);
		acc1.displayaccount();
		
		System.out.println();
		
		acc2.deposit(2000);
		acc2.withdrawal(8000);
		acc2.displayaccount();
		
	}
}
