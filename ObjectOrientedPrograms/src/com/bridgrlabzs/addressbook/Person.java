package com.bridgrlabzs.addressbook;

public class Person {
       String firstName;
       String lastName;
       Address address;
       String phoneNumber;
       
       public String getFirstName() {
    	   return firstName;
    	   
       }
       public void setFirstName(String firstName) {
    	   this.firstName = firstName;
    	   
       }
       
       public String getLastName() {
		   return lastName;
    	   
       }
       
       public void setLastName(String lastName) {
    	   this.lastName = lastName;
    	   
       }
       
       public Address getAddress() {
		   return address;
    	   
       }
       
       public void setAddress(Address address) {
    	   this.address = address;
    	   
       }
       
       public String getPhoneNumber() {
		   return phoneNumber;
    	   
       }
       
       public void setPhoneNumber(String phoneNumber) {
    	   this.phoneNumber = phoneNumber;
    	   
       }
       @Override
       public String toString() {
   		  return "\n\t\t\t\tPerson \n\t\t\t\tFirst Name :" + firstName + "\n\t\t\t\tLast Name :" + lastName + "\n\t\t\t\tAddress :" + address + "\n\t\t\t\tPhone Number :"+ phoneNumber + "\n\n" ;
       	 
        }
}
