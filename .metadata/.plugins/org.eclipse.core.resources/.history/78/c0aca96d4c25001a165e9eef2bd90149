package com.bridgelabzs.utility;

import java.util.Random;
import java.util.Scanner;

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

	
}
