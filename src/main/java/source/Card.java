package source;

import source.Suit;
import java.lang.Comparable;


public class Card implements Comparable{
    private Suit suit;
    private char rate;
    private int score;

    public Suit getSuit(){
            return(suit);
    }
    public char getRate(){
            return(rate);
    }
    public void setScore(int i) {
    	this.score = i;
  /*          if ((i>=2)&&(i<=10)) {
                    score=i;
            }
            else {
                    if (i<14) {
                            score=10;
                    }
                    else {
                            score=11;
                    }
            }
            if (i<2) {
                    score=1;
            } */
    }
    public void setRate(int i){
            if ((i>=2)&&(i<=9)) {
                    i+=48;
                    rate=(char) i;
            } else {
                    switch (i) {
                            case 10: {
                                    rate='T';
                                    break;
                            }
                            case 11: {
                                    rate='J';
                                    break;
                            }
                            case 12: {
                                    rate='Q';
                                    break;
                            }
                            case 13: {
                                    rate='K';
                                    break;
                            }
                            case 14: {
                                    rate='A';
                                    break;
                            }
                                    
                    }               
            }
    }
    public void setSuit(Suit i){
            suit=i;
    }
    @Override
    public String toString() {
      return String.valueOf(rate)+suit;
    }
    
    public int getScore() {
            return score;
            
    }

    @Override
    public int compareTo(Object obj) {
    	Card card = (Card) obj;
    	if (score == card.getScore()) return 0;
    	if (score > card.getScore()) return -1; 
    			else
    				return 1;
    }
}
