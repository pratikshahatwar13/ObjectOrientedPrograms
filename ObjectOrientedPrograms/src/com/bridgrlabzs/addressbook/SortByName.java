package com.bridgrlabzs.addressbook;

import java.util.Comparator;

public class SortByName implements Comparator<Person> {
	//compare data and returns 0 is data same,1 if first data is greater and -1 if second data is greater
	public int compare(Person personOne ,Person  personTwo) {
		if(personOne.getFirstName().equals(personTwo.getFirstName()))
			return 0;
		else {
			if(personOne.getFirstName().compareTo(personTwo.getFirstName())>0) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}

}
