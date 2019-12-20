package com.bridgelabzs.programs;

import com.bridgelabzs.utility.Utility;

public class DeckOfCards {

	public static void main(String[] args) {
		
		Utility utility = new Utility();
		String[] cards = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String[] names = {"Clubs","Diamonds","Hearts","Spades"};
		int deck[][] = utility.shuffle();
		System.out.println("Before sorting \n==============");
		for(int i=0;i<4;i++) {
			for(int j=0;j<9;j++) {
				if(deck[i][j]>=0 && deck[i][j]<=12)
					System.out.print(names[0]+"["+cards[deck[i][j]]+"]\t");
				else if(deck[i][j]>=13 && deck[i][j]<=25)
					System.out.print(names[1]+"["+cards[(deck[i][j])%13]+"]\t");
				else if(deck[i][j]>=26 && deck[i][j]<=38)
					System.out.print(names[2]+"["+cards[(deck[i][j])%13]+"]\t");
				else if(deck[i][j]>=39 && deck[i][j]<=51)
					System.out.print(names[3]+"["+cards[(deck[i][j])%13]+"]\t");
			}
			System.out.println("");
			System.out.println();
		}
		System.out.println("\n============================================\n");
		deck = utility.sort(deck);
		System.out.println("After sorting \n==============");
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		for(int i=0;i<4;i++) {
			for(int j=0;j<9;j++) {
				queue.add(deck[i][j]);
			}
		}
		queue.display();
		
	}

}
