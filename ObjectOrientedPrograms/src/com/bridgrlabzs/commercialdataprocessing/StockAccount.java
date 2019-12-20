package com.bridgrlabzs.commercialdataprocessing;

public class StockAccount {

	CompanyShare share[];
	private int amount;
	int number=0;
	double price;
	
	public StockAccount() {
		
	}
	
	public StockAccount(CompanyShare share[]) {
		this.share = share;
		
	}
	
	public boolean CheckShare() {
		int number = share[0].getShare();
		if(number!=0)
		{
			return true;
		}
		else
		{
			return false;
			
		}
	}
	
	public double valueOf()
	{
		return 0;
	}
	
	public CompanyShare[] buy(int amount, String symbol) {
		double price = share[0].getPrice();
		price=price-amount;
		share[0].setPrice(price);
		int sh=(share[0].getShare()+1);
		share[0].setShare(sh);
		return share;
		
	}
	
	public CompanyShare[] sell(int amount,String symbol) {
		double price = share[0].getPrice();
		price=price+amount;
		share[0].setPrice(price);
		int sh=(share[0].getShare()-1);
		share[0].setShare(sh);
		return share;
		
	}
	
	public void printReport(CompanyShare share[] ) {
		System.out.println(share[0]);
	}
	
}
