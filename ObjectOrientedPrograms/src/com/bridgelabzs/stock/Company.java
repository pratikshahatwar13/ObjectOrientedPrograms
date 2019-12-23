package com.bridgelabzs.stock;

public class Company {

	private String company;
	private long sharesAvailable;
	private long pricePerShare;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public long getSharesAvailable() {
		return sharesAvailable;
	}
	public void setSharesAvailable(long sharesAvailable) {
		this.sharesAvailable = sharesAvailable;
	}
	public long getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(long pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	@Override
	public String toString() {
		return "\n\t\t\tCompany \n\t\t\t\tcompany : " + company + "\n\t\t\tsharesAvailable : " + sharesAvailable + "\n\t\t\t\tpricePerShare : " + pricePerShare + "\n";
		
	}
	
}
