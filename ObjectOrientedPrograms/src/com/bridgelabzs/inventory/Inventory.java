package com.bridgelabzs.inventory;

public class Inventory {
	private String name;
	private long weight;
	private long pricePerKg;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public long getPricePerKg() {
		return pricePerKg;
	}
	public void setPricePerKg(long pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	@Override
	public String toString() {
		return "Inventary [name=" + name + ", weight=" + weight + ", pricePerKg=" + pricePerKg + "]";
	}
}
