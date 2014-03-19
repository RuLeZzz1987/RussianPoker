package source;

public class GameRules {
	
	private GameType gameType;
	private BoxStatus gameStatus;
	private int boxCount;
	
	public GameRules(GameType type, int boxCount) {
		gameType = type;
		this.boxCount = boxCount;
	}
}
