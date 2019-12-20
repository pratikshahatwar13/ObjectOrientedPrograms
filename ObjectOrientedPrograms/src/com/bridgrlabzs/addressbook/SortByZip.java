package com.bridgrlabzs.addressbook;

import java.util.Comparator;

public class SortByZip implements Comparator<Person> {

	//compare data and returns 0 is data same,1 if first data is greater and -1 if second data is greater
	
	public int compare(Person p1,Person p2) {
		if(p1.address.getZip() == p2.address.getZip())
			return 0;
		else {
			if(p1.address.getZip()>p2.address.getZip()) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}
}
