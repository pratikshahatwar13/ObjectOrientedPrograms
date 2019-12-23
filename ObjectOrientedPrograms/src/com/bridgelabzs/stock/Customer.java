package com.bridgelabzs.stock;

public class Customer {

	private String symbol;
	private long amount;
	private long shares;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getShares() {
		return shares;
	}
	public void setShares(long shares) {
		this.shares = shares;
	}
	@Override
	public String toString() {
		return "\n\t\t\tCustomer \n\t\t\t\tsymbol : " + symbol + "\n\t\t\tshares : " + shares +  "\n";
		
	}
}
