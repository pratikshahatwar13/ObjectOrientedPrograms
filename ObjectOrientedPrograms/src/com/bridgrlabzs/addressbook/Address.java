package com.bridgrlabzs.addressbook;

public class Address {
     String city;
     String state;
     long zip;
     public String getCity(){
		return city; 
		
     }
     public void setCity(String city){
    	 this.city=city;
    	 
     }
     public String getState() {
		return city;
    	 
     }
     public void setState(String state) {
    	 this.state=state;
    	 
     }
     public long getZip() {
		return zip;
    	 
     }
     public void setZip(long zip) {
    	 this.zip=zip;
    	 
     }
     @Override
     public String toString() {
		return "\n\t\t\t\t city :" + city +"\n\t\t\t\t State:" + state + "\n\t\t\t\t zip :" + zip ;
    	 
     }
}
