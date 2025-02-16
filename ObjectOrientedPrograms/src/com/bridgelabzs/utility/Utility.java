package com.bridgelabzs.utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import com.bridgelabzs.model.Appointment;
import com.bridgelabzs.model.Doctor;
import com.bridgelabzs.model.Patient;
import com.bridgelabzs.stock.Company;

public class Utility {

	Scanner scanner;
	Random random;

	public Utility() {
		scanner = new Scanner(System.in);
		random = new Random();

	}

	public int inputRandom(int bound) {
		try {
			return random.nextInt(bound);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public int inputRandom() {
		try {
			return random.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public String inputString() {
		try {
			return scanner.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}

	public String inputStringLine() {
		try {
			return scanner.nextLine();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}

	public int inputInteger() {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public double inputDouble() {
		try {
			return scanner.nextDouble();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public boolean inputBoolean() {
		try {
			return scanner.nextBoolean();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	/*
	 * @return shuffled array 
	 */
	public int[][] shuffle() {
		int size = 9;
		int[][] cards= new int[4][size];
		
		cards = randomArray(size);
		return cards;
	}
	/*
	 * @param size is the number of cards each player receives
	 * @return the 2D array of 4x9 with random cards for 4 players
	 */
	private int[][] randomArray(int size) {
		int r=0;
		int c=0;
		int random = 0;
		int x = 0;
		int bound = 52;
		int[][] array = new int[4][size];
		while(c<4) {
			r=0;
			x=0;
			
		while(r<size) {
			if(r==0 && c==0 )
				array[c][r] = inputRandom(bound);
			else {
				int z = 0;
				x = 0;
				while(z==0) {
					random = inputRandom(bound);
					x=0;
					z=0;
					for(int i=0;i<4;i++) {
						for(int j=0;j<size;j++) {
							if(array[i][j]==random)
								x++;
						}
					}
					if(x==0) {
						array[c][r] = random;
						z++;
					}
				}
				}
			r++;
			}
		c++;
		}
		return array;
		}
	/*
	 * @param deck is the array where all the player cards are stored in random order
	 * @return the cards of each player in ascending order 
	 */
	public int[][] sort(int[][] deck) {
		int size = 9;
		int[] player1 = new int[size];
		int[] player2 = new int[size];
		int[] player3 = new int[size];
		int[] player4 = new int[size];
		for(int i=0;i<4;i++) {
			for(int j=0;j<size;j++) {
				if(i==0)
					player1[j] = deck[i][j];
				else if(i==1)
					player2[j] = deck[i][j];
				else if(i==2)
					player3[j] = deck[i][j];
				else if(i==3)
					player4[j] = deck[i][j];
			}
		}
		player1 = bubbleSort(player1);
		player2 = bubbleSort(player2);
		player3 = bubbleSort(player3);
		player4 = bubbleSort(player4);
		int[][] array = new int[4][size];
		for(int i = 0;i<4;i++) {
			for(int j=0;j<size;j++) {
				if(i==0) 
					array[i][j] = player1[j];
				else if(i==1)
					array[i][j] = player2[j];
				else if(i==2)
					array[i][j] = player3[j];
				else if(i==3)
					array[i][j] = player4[j];
			}
		}

		return array;
	}

	/*
	 * @param array
	 * @return sorted array
	 */
	private int[] bubbleSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-1;j++) {
				if((array[j]%13)>(array[(j+1)])%13) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}

	/*
	 * Computes total price of share and display the table of company share and
	 * price
	 */
	public static void getstockReport() {
		String name;
		long sharesAvailable;
		long pricePerShare;
		long price;
		long totalPrice = 0;
		JSONParser jsonParser = new JSONParser();
		System.out.println("Company\t\t\t\tShares\t\t\t\tPrice per share\t\tPrice");
		System.out.println("=======\t\t\t\t======\t\t\t\t===============\t\t=====");
		try {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("/home/user/ObjectOrientedPrograms/ObjectOrientedPrograms/Stock/stockInput.json"));
			for (Object o : jsonArray) {
				JSONObject jsonObject = (JSONObject) o;
				name = (String) jsonObject.get("Company");
				System.out.print(name + "\t\t\t\t");
				sharesAvailable = (long) jsonObject.get("SharesAvailable");
				System.out.print(sharesAvailable + "\t\t\t\t");
				pricePerShare = (long) jsonObject.get("PricePerShare");
				System.out.print(pricePerShare + "\t\t\t");
				price = pricePerShare * sharesAvailable;
				System.out.print(price);
				totalPrice = totalPrice + price;
				System.out.println();
			}
			System.out.println("\nTotal Price : " + totalPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calculates the total value
	 */
	public void stockTotalShares() {
		JSONParser jsonParser = new JSONParser();
		try {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("/home/user/ObjectOrientedPrograms/ObjectOrientedPrograms/Stock/stockAccountInput.json"));
			System.out.println(jsonArray);
			System.out.println("=================================================");
			System.out.println("Symbol\t  Price Per Share    Total Shares");
			System.out.println("======\t  ===============    ============");
			for (Object o : jsonArray) {
				JSONObject jsonObject = (JSONObject) o;
				String symbol = (String) jsonObject.get("Symbol");
				System.out.print(symbol + "\t\t");
				long priceperShare = (long) jsonObject.get("PricePerShare");
				System.out.print(priceperShare + "\t\t");
				long totalShare = (long) jsonObject.get("TotalShare");
				System.out.print(totalShare + "\t\t");
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Buying shares and updating it in json file
	 * 
	 * @param amount
	 *            Amount by which user will buy shares
	 * @param userSymbol
	 *            company symbol for buying shares of that particular company
	 */
	@SuppressWarnings("unchecked")
	public void buyShares(int amount, String userSymbol) {
		JSONParser jsonParser = new JSONParser();
		long totalShare;
		long pricePerShare;
		long totalSharesAfterPurchase;
		try {
			JSONArray jsonArrayOut = new JSONArray();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("/home/user/ObjectOrientedPrograms/ObjectOrientedPrograms/Stock/stockAccountInput.json"));
			for (Object o : jsonArray) {
				JSONObject jsonObject = (JSONObject) o;
				String company = (String) jsonObject.get("Company");
				String symbol = (String) jsonObject.get("Symbol");
				totalShare = (long) jsonObject.get("TotalShare");
				pricePerShare = (long) jsonObject.get("PricePerShare");
				if (symbol.equals(userSymbol)) {
					totalSharesAfterPurchase = totalShare - (amount / pricePerShare);
					System.out.println("Updated Stock");
					System.out.println("=================================================");
					System.out.println("Symbol\t  Price Per Share    Total Shares");
					System.out.println("======\t  ===============    ============");
					System.out.print(symbol + "\t\t");
					System.out.print(pricePerShare + "\t\t");
					System.out.println(totalSharesAfterPurchase + "\t\t");
					jsonObject.put("Company", company);
					jsonObject.put("Symbol", symbol);
					jsonObject.put("PricePerShare", pricePerShare);
					jsonObject.put("TotalShare", totalSharesAfterPurchase);
				} else {
					jsonObject.put("Company", company);
					jsonObject.put("Symbol", symbol);
					jsonObject.put("PricePerShare", pricePerShare);
					jsonObject.put("TotalShare", totalShare);
				}
				jsonArrayOut.add(jsonObject);
			}
			FileWriter file = new FileWriter("json/stockAccountInput.json");
			file.write(jsonArrayOut.toJSONString());
			file.flush();
			file.close();
			System.out.println("Successfully written output in file");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Selling shares and updating in json file
	 * 
	 * @param amount
	 *            Entered by user to sell shares
	 * @param userSymbol
	 *            Company symbol required for selling shares
	 */
	public void sellShares(int amount, String userSymbol) {
		JSONParser jsonParser = new JSONParser();
		long totalShare;
		long pricePerShare;
		long totalSharesAfterPurchase;
		try {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("/home/user/ObjectOrientedPrograms/ObjectOrientedPrograms/Stock/stockAccountInput.json"));
			for (Object o : jsonArray) {
				JSONObject jsonObject = (JSONObject) o;
				String symbol = (String) jsonObject.get("Symbol");
				totalShare = (long) jsonObject.get("TotalShare");
				if (symbol.equals(userSymbol)) {
					pricePerShare = (long) jsonObject.get("PricePerShare");
					totalSharesAfterPurchase = totalShare + (amount / pricePerShare);
					System.out.println("Updated Stock");
					System.out.println("=================================================");
					System.out.println("Symbol\t  Price Per Share    Total Shares");
					System.out.println("======\t  ===============    ============");
					System.out.print(symbol + "\t\t");
					System.out.print(pricePerShare + "\t\t");
					System.out.println(totalSharesAfterPurchase + "\t\t");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Creates new file with the name of the user and keeps all their transactions
	 * 
	 * @param filename name with which new json file is being created
	 */
	public void createNewAccount(String filename) {
		File file = new File("/home/user/ObjectOrientedPrograms/ObjectOrientedPrograms/Stock" + filename + ".json");
		boolean fileCreated = false;
		try {
			fileCreated = file.createNewFile();
		} catch (IOException e) {
			System.out.println("Error creating file : " + e);
		}
		if (fileCreated)
			System.out.println("File Created : " + file.getPath());
		else
			System.out.println("Failed to creat file : " + file.getPath());
	}

	/*
	 * Calculates total values of all the shares in the stock 
	 * 
	 * @param company list where all info is present
	 * @return total value of all the shares share
	 */
	public long totalValueOfShares(List<Company> company) {
		long totalShares = 0;
		for (Company c : company) {
			long share = c.getSharesAvailable();
			long price = c.getPricePerShare();
			totalShares += (share * price);
		}
		return totalShares;
	}
	/**
	 * Purpose : Adding doctors in doctor object and returning the object
	 * 
	 * @return object having doctor data
	 */
	public Doctor addDoctorToList() {
		Doctor doctor = new Doctor();
		System.out.println("\n\t\t\tEnter Name");
		doctor.setName(inputString());
		System.out.println("\n\t\t\tEnter ID in number");
		doctor.setId(inputInteger());
		System.out.println("\n\t\t\tEnter Specialization");
		doctor.setSpecialization(inputString());
		System.out.println("\n\t\t\tEnter Availability");
		doctor.setAvailability(inputString());
		doctor.setNumberOfPatients(0);
		return doctor;
	}

	/**
	 * Purpose : Adding patient in patient object and returning the object
	 * 
	 * @return object of having patient data
	 */
	public Patient addPatientToList() {
		Patient patient = new Patient();

		System.out.println("\n\t\t\tEnter Name");
		patient.setName(inputString());
		System.out.println("\n\t\t\tEnter ID in number");
		patient.setId(inputInteger());
		System.out.println("\n\t\t\tEnter Phone Number");
		patient.setPhone(inputString());
		System.out.println("\n\t\t\tEnter Age");
		patient.setAge(inputInteger());
		return patient;
	}

	/**
	 * Purpose : Adding appointment details in appointment object and returning the object
	 * 
	 * @param doctorList
	 * @param patientList
	 * @return
	 */
	public Appointment addAppointmentToList(List<Doctor> doctorList, List<Patient> patientList) {
		Appointment appointment = new Appointment();
		System.out.println("\n\t\t\tEnter name of Patient");
		String patientAppointment = inputString();
		int count = 0;
		for (Patient patient : patientList) {
			if (patient.getName().equals(patientAppointment)) {
				count++;
				System.out.println("\n\t\t\tEnter the name of Doctor for Appointment");
				String doctorAppointment = inputString();
				System.out.println("\n\t\t\tEnter the ID of Doctor for Appointment");
				long doctorAppointmentId = inputInteger();
				Date d = new Date();
				String date = d.toString();
				for (Doctor doctor : doctorList) {
					if (doctor.getName().equals(doctorAppointment)) {
						if (doctor.getId() == doctorAppointmentId) {
							if (doctor.getNumberOfPatients() < 5) {
								appointment.setDoctor(doctor);
								appointment.setPatient(patient);
								appointment.setDate(date);
								doctor.setNumberOfPatients(doctor.getNumberOfPatients() + 1);
								System.out.println("\n\t\t\tAppointment fixed on " + date);
								return appointment;
							} else {
								System.out.println("\n\t\t\tTake appointment on some other day\n\t\t\tDoctor reached maximum number of patients");
							}
						}
					}
				}
			}
		}
		if (count == 0) {
			System.out.println("\n\t\t\tSorry you are not a registered patient\nClinic closed");
			System.exit(0);
		}
		return null;
	}
	
}
