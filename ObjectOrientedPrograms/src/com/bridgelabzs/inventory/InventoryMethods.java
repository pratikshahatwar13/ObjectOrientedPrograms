package com.bridgelabzs.inventory;

import java.util.List;

public interface InventoryMethods {

	public Inventory addInventory();
	public long totalWeight(List<Inventory> inventaryList);
	public long totalPrice(List<Inventory> inventaryList);
	public void display(List<Inventory> inventaryList);
	public List<Inventory> removeInventory(List<Inventory> inventaryList);
}
