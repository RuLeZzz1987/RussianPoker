package source;

import java.util.ArrayList;

public class GameMath{
	
	private int f = 0;
	private ArrayList<ArrayList<Card>> combin = new ArrayList<ArrayList<Card>>();
	private ArrayList<CardsDraw> possibleChanges = new ArrayList<CardsDraw>();
	
	public void addPossibleChanges(Hand hand, ArrayList<Card> knownCards, ArrayList<Card> cards) {
			possibleChanges.add(new CardsDraw(hand, knownCards, cards));		
	}
	
	public ArrayList<CardsDraw> getPossibleChanges() {
		return possibleChanges;
	}
	
	public ArrayList<ArrayList<Card>> generatePossibleChanges(ArrayList<Card> cardList, int k) {
		int g = cardList.size();
		combinate(cardList, g, k);
		return combin;
	}

	private void combinate(ArrayList<Card> cardList, int size, int k) {
		Card[] data = new Card[k];
		combinationUtil(cardList, data, 0, size-1, 0, k);
		
	}

	private void combinationUtil(ArrayList<Card> cardList,
			Card[] data, int start, int end, int index, int k) {
		 if (index == k)
		    {		
			 combin.add(new ArrayList<Card>());
		        for (int j=0; j<k; j++)
		            combin.get(f).add(data[j]); 
			 	f++;
			 	return;
		    }
		 	
		    for (int i=start; i<=end && end-i+1 >= k-index; i++)
		    {
		        data[index] = cardList.get(i);
		        combinationUtil(cardList, data, i+1, end, index+1, k);
		    }
		
	}



	
}
