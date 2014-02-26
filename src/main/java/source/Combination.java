package source;

public class Combination {
	
	private String code;
	private String name;
	private int[] kickers = new int[5]; 
	
	public Combination(String code) {
		this.code = code;
		getName(code);
		getKickersList(code);
	}

	public String getCombCode() {
		return code;
	}
	
	private void getKickersList(String code) {
		
	}
	
	private void getName(String code) {
		switch (code.charAt(0)) {
			case '0' : {
				this.name = "Don't qualify";
				break;
			}
			case '1' : {
				if ( code.charAt(1) != '0' ) {
					this.name = "Ace & King";
				} else {
					this.name = "Royal flush";
				}
				break;
			}
			case '2' : {
				this.name = "Pair";
				break;
			}
			case '3' : {
				this.name = "Two pairs";
				break;
			}
			case '4' : {
				this.name = "Three of a kind";
				break;
			}
			case '5' : {
				this.name = "Straight";
				break;
			}
			case '6' : {
				this.name = "Flush";
				break;
			}
			case '7' : {
				this.name = "Full house";
				break;
			}
			case '8' : {
				this.name = "Four of a kind";
				break;
			}
			case '9' : {
				this.name = "Straigh flush";
				break;
			}
		}
	}
}
